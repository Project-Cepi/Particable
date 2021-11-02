package world.cepi.particle.renderer

import net.kyori.adventure.audience.Audience
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Vec
import net.minestom.server.timer.Task
import world.cepi.particle.Particle
import world.cepi.particle.renderer.animation.TransformAnimation
import world.cepi.particle.renderer.shape.*
import world.cepi.particle.renderer.transform.VectorTranslate
import world.cepi.particle.showParticle
import java.awt.Shape
import java.time.Duration
import java.util.function.UnaryOperator
import kotlin.math.PI
import kotlin.math.asin

class Renderer internal constructor() : VecIterable {
    companion object {
        fun point() = Renderer().shape(PointRenderer)

        fun fixedLine(from: Vec, to: Vec, step: Double = 0.1) = Renderer().shape(LineRenderer(from.max(to).sub(from.min(to)), step))
            .translate(from.min(to))

        fun rectangle(vec: Vec, step: Double = 0.2) = Renderer()
            .shape(line(Vec(vec.x(), .0, .0), step))
            .shape(line(Vec(.0, vec.y(), .0), step))
            .shape(line(Vec(.0, .0, vec.z()), step))

            .shape(fixedLine(Vec(.0, vec.y(), .0), Vec(.0, vec.y(), vec.z()), step))
            .shape(fixedLine(Vec(.0, vec.y(), .0), Vec(vec.x(), vec.y(), .0), step))

            .shape(fixedLine(Vec(vec.x(), .0, vec.z()), Vec(.0, .0, vec.z()), step))
            .shape(fixedLine(Vec(vec.x(), .0, vec.z()), Vec(vec.x(), .0, .0), step))

            .shape(fixedLine(vec, Vec(.0, vec.y(), vec.z()), step))
            .shape(fixedLine(vec, Vec(vec.x(), vec.y(), .0), step))

            .shape(fixedLine(vec, Vec(vec.x(), .0, vec.z()), step))
            .shape(fixedLine(Vec(vec.x(), vec.y(), .0), Vec(vec.x(), .0, .0), step))
            .shape(fixedLine(Vec(.0, vec.y(), vec.z()), Vec(.0, .0, vec.z())))

        fun fixedRectangle(from: Vec, to: Vec, step: Double = 0.1) = Renderer().shape(rectangle(from.max(to).sub(from.min(to)), step))
            .translate(from.min(to))

        fun line(vector: Vec, step: Double = 0.1) = Renderer().shape(LineRenderer(vector, step))

        fun points(vararg points: Vec) = Renderer().shape(points.asIterable())

        fun polygon(points: Iterable<Vec>, step: Double = 0.1) = Renderer().shape(PolygonRenderer(points, step))
        fun polygon(vararg points: Vec,  step: Double = 0.1) = Renderer().shape(PolygonRenderer(points.asIterable(), step))

        fun circle(radius: Double, divisions: Int = (2 * PI / asin(0.1 / radius)).toInt()) =
            Renderer().shape(CircleRenderer(radius, divisions))

        fun filledCircle(radius: Double, innerDivisions: Int = (radius * 10).toInt(), particleSpacing: Double = 0.1) =
            Renderer().shape(FilledCircleRenderer(radius, innerDivisions, particleSpacing))

        fun sphere(radius: Double, particleSpacing: Double = 0.1) = Renderer().shape(SphereRenderer(radius, particleSpacing))
    }

    private var shapes = mutableListOf<VecIterable>()

    private var transform: Transform? = null

    private var animation: Animation? = null

    private var repeat = Duration.ZERO

    fun shape(vararg renderers: VecIterable) = apply { this.shapes.addAll(renderers) }
    fun shape(iterable: VecIterable) = apply { this.shapes.add(iterable) }

    fun translate(x: Double, y: Double, z: Double) = apply { transform = VectorTranslate(Vec(x, y, z)) }
    fun translate(vec: Vec) = apply { transform = VectorTranslate(vec) }

    fun animate(repeat: Duration, animation: Animator.(Int) -> Unit) = apply {
        this.animation = buildTransformAnimation(animation)
        this.repeat = repeat
    }

    fun renderOnce(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this)

    fun startRender(particle: Particle<*, *>, audience: Audience, delay: Duration = Duration.ZERO): Task {
        return (if (animation is TransformAnimation) {
            var i = 0
            MinecraftServer.getSchedulerManager().buildTask {
                audience.showParticle(particle, Renderer().apply {
                    this@apply.shapes = this@Renderer.shapes
                    this@apply.transform = Transform {
                        (this@Renderer.animation as TransformAnimation)
                            .invoke(this@Renderer.transform?.apply(it) ?: it, i)
                    }
                })
                ++i
            }
        } else if (animation != null) {
            MinecraftServer.getSchedulerManager().buildTask {
                shapes.flatten().forEachIndexed { index, vec ->
                    audience.showParticle(particle, animation!!.invoke(transform?.apply(vec) ?: vec, index))
                }
            }
        } else MinecraftServer.getSchedulerManager().buildTask {
            audience.showParticle(particle, this)
        }).delay(delay).repeat(repeat).schedule()
    }

    override fun iterator(): Iterator<Vec> {
        val it = shapes.flatten().iterator()
        return object : Iterator<Vec> {
            override fun hasNext(): Boolean = it.hasNext()

            override fun next(): Vec = it.next().let { v -> transform?.apply(v) ?: v }
        }
    }

    fun interface Transform : UnaryOperator<Vec>

    fun interface Animation : (Vec, Int) -> Vec
}