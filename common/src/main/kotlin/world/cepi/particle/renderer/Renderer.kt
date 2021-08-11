package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.Particle
import kotlin.math.PI
import kotlin.math.asin

sealed interface Renderer : Particle.Renderer, Iterable<Vector> {
    companion object {
        fun point() = PointRenderer

        fun line(start: Vector, end: Vector, step: Double = 0.1) = LineRenderer(start, end, step)

        fun points(points: Iterable<Vector>) = PointsRenderer(points)
        fun points(vararg points: Vector) = PointsRenderer(points.asIterable())

        fun polygon(points: Iterable<Vector>, step: Double = 0.1) = PolygonRenderer(points, step)
        fun polygon(vararg points: Vector,  step: Double = 0.1) = PolygonRenderer(points.asIterable(), step)

        fun circle(radius: Double, divisions: Int = (2 * PI / asin(0.1 / radius)).toInt()) =
            CircleRenderer(radius, divisions)

        fun filledCircle(radius: Double, innerDivisions: Int = (radius * 10).toInt(), particleSpacing: Double = 0.1) =
            FilledCircleRenderer(radius, innerDivisions, particleSpacing)

        fun sphere(radius: Double, particleSpacing: Double = 0.1) = SphereRenderer(radius, particleSpacing)
    }
}