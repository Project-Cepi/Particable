package world.cepi.particle

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.*
import kotlin.math.PI
import kotlin.math.asin

fun interface Renderer : Particle.Renderer, Iterable<Vector> {
    companion object {
        fun point() = PointRenderer

        fun line(start: Vector, end: Vector, step: Double = 0.1) = LineRenderer(start, end, step)

        fun points(points: Iterable<Vector>) = PointsRenderer(points)
        fun points(vararg points: Vector) = PointsRenderer(points.asIterable())

        fun polygon(points: Iterable<Vector>, step: Double = 0.1) = PolygonRenderer(points, step)
        fun polygon(vararg points: Vector,  step: Double = 0.1) = PolygonRenderer(points.asIterable(), step)

        fun circle(radius: Double, axis: CircleRenderer.Axis = CircleRenderer.Axis.XZ, divisions: Int = (2 * PI / asin(0.1 / radius)).toInt()) =
            CircleRenderer(radius, axis, divisions)

        fun filledCircle(radius: Double, axis: CircleRenderer.Axis = CircleRenderer.Axis.XY, innerDivisions: Int = (radius * 10).toInt(), particleSpacing: Double = 0.1) =
            FilledCircleRenderer(radius, axis, innerDivisions, particleSpacing)

        fun sphere(radius: Double, particleSpacing: Double = 0.1) = SphereRenderer(radius, particleSpacing)
    }
}