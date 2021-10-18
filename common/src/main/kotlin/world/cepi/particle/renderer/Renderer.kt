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
import java.time.Duration
import java.util.function.UnaryOperator
import kotlin.math.PI
import kotlin.math.asin

class Renderer internal constructor() : Particle.Renderer {
    companion object {
        fun point() = Renderer().shape(PointRenderer())

        fun fixedLine(from: Vec, to: Vec, step: Double = 0.1) = Renderer().shape(LineRenderer(from.max(to).sub(from.min(to)), step))
            .translate(from.min(to))

        fun rectangle(vec: Vec, step: Double = 0.1) = Renderer()
            .shape(line(Vec(vec.x(), .0, .0), step))
            .shape(line(Vec(.0, vec.y(), .0), step))
            .shape(line(Vec(.0, .0, vec.z()), step))

            .shape(fixedLine(Vec(.0, vec.y(), .0), Vec(.0, vec.y(), vec.z()), step))
            .shape(fixedLine(Vec(.0, vec.y(), .0), Vec(vec.x(), vec.y(), .0), step))

            .shape(fixedLine(Vec(vec.x(), .0, vec.z()), Vec(.0, .0, vec.z()), step))
            .shape(fixedLine(Vec(vec.x(), .0, vec.z()), Vec(vec.x(), .0, .0), step))

            .shape(fixedLine(vec, Vec(.0, vec.y(), vec.z()), step))
            .shape(fixedLine(vec, Vec(vec.x(), vec.y(), .0), step))

            .shape(fixedLine(vec, Vec(.0, .0, vec.z()), step))
            .shape(fixedLine(vec, Vec(vec.x(), .0, .0), step))

        fun fixedRectangle(from: Vec, to: Vec, step: Double = 0.1) = Renderer().shape(rectangle(from.max(to).sub(from.min(to)), step))
            .translate(from.min(to))

        fun line(vector: Vec, step: Double = 0.1) = Renderer().shape(LineRenderer(vector, step))

        fun points(points: Iterable<Vec>) = Renderer().shape(PointsRenderer(points))
        fun points(vararg points: Vec) = Renderer().shape(PointsRenderer(points.asIterable()))

        fun polygon(points: Iterable<Vec>, step: Double = 0.1) = Renderer().shape(PolygonRenderer(points, step))
        fun polygon(vararg points: Vec,  step: Double = 0.1) = Renderer().shape(PolygonRenderer(points.asIterable(), step))

        fun circle(radius: Double, divisions: Int = (2 * PI / asin(0.1 / radius)).toInt()) =
            Renderer().shape(CircleRenderer(radius, divisions))

        fun filledCircle(radius: Double, innerDivisions: Int = (radius * 10).toInt(), particleSpacing: Double = 0.1) =
            Renderer().shape(FilledCircleRenderer(radius, innerDivisions, particleSpacing))

        fun sphere(radius: Double, particleSpacing: Double = 0.1) = Renderer().shape(SphereRenderer(radius, particleSpacing))
    }

    private var shapes = mutableListOf<Shape>()

    private var transform: Transform? = null

    private var animation: Animation? = null

    private var repeat = Duration.ZERO

    fun shape(vararg shapes: Shape) = apply { this.shapes.addAll(shapes) }

    fun shape(renderer: Renderer) = apply { this.shapes.addAll(renderer.shapes)}

    fun translate(x: Double, y: Double, z: Double) = apply { transform = VectorTranslate(Vec(x, y, z)) }
    fun translate(vec: Vec) = apply { transform = VectorTranslate(vec) }

    fun animate(repeat: Duration, animation: Animator.(Int) -> Unit) = apply {
        this.animation = buildTransformAnimation(animation)
        this.repeat = repeat
    }

    fun animatePerParticle(repeat: Duration, animation: Animator.(Int, Float) -> Unit) = apply {
        this.animation = buildPerParticleAnimation(animation)
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
                            .invoke(this@Renderer.transform?.apply(it) ?: it, i, 0f)
                    }
                })
                ++i
            }
        } else if (animation != null) {
            val count = shapes.sumOf { it.count }.toFloat()
            MinecraftServer.getSchedulerManager().buildTask {
                for ((i, v) in shapes.flatten().iterator().withIndex()) {
                    audience.showParticle(particle, animation!!.invoke(transform?.apply(v) ?: v, i, i / count))
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

    abstract class Shape : Iterable<Vec> {
        val count by lazy {
            var i = 0
            for (_0 in iterator()) ++i
            i
        }
    }

    fun interface Transform : UnaryOperator<Vec>

    fun interface Animation : (Vec, Int, Float) -> Vec
}