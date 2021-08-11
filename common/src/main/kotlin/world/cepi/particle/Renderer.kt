package world.cepi.particle

import net.minestom.server.utils.Position
import world.cepi.particle.renderer.*
import kotlin.math.PI
import kotlin.math.asin

fun interface Renderer : Particle.Renderer, Iterable<Position> {
    companion object {
        fun point() = PointRenderer

        fun line(start: Position, end: Position, step: Double = 0.1) = LineRenderer(start, end, step)

        fun points(points: Iterable<Position>) = PointsRenderer(points)
        fun points(vararg points: Position) = PointsRenderer(points.asIterable())

        fun polygon(points: Iterable<Position>, step: Double = 0.1) = PolygonRenderer(points, step)
        fun polygon(vararg points: Position,  step: Double = 0.1) = PolygonRenderer(points.asIterable(), step)

        fun circle(radius: Double, axis: CircleRenderer.Axis = CircleRenderer.Axis.XZ, divisions: Int = (2 * PI / asin(0.1 / radius)).toInt()) =
            CircleRenderer(radius, axis, divisions)

        fun filledCircle(center: Position, radius: Double, axis: CircleRenderer.Axis = CircleRenderer.Axis.XY, innerDivisions: Int = (radius * 10).toInt(), particleSpacing: Double = 0.1) =
            FilledCircleRenderer(center, radius, axis, innerDivisions, particleSpacing)

        fun sphere(radius: Double, particleSpacing: Double = 0.1) = SphereRenderer(radius, particleSpacing)
    }
}