package world.cepi.particle.renderer

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.shape.*
import world.cepi.particle.util.Vectors
import kotlin.math.PI
import kotlin.math.asin

object Renderer {
    fun point() = Vec.ZERO

    fun fixedLine(from: Vec, to: Vec, step: Double = 0.1) = Vectors(from, to, step)

    fun rectangle(vec: Vec, step: Double = 0.2) = line(Vec(vec.x(), .0, .0), step) +
            line(Vec(.0, vec.y(), .0), step) +
            line(Vec(.0, .0, vec.z()), step) +

            fixedLine(Vec(.0, vec.y(), .0), Vec(.0, vec.y(), vec.z()), step) +
            fixedLine(Vec(.0, vec.y(), .0), Vec(vec.x(), vec.y(), .0), step) +

            fixedLine(Vec(vec.x(), .0, vec.z()), Vec(.0, .0, vec.z()), step) +
            fixedLine(Vec(vec.x(), .0, vec.z()), Vec(vec.x(), .0, .0), step) +

            fixedLine(vec, Vec(.0, vec.y(), vec.z()), step) +
            fixedLine(vec, Vec(vec.x(), vec.y(), .0), step) +

            fixedLine(vec, Vec(vec.x(), .0, vec.z()), step) +
            fixedLine(Vec(vec.x(), vec.y(), .0), Vec(vec.x(), .0, .0), step) +
            fixedLine(Vec(.0, vec.y(), vec.z()), Vec(.0, .0, vec.z()))

    fun quadraticBeizerCurveRenderer(start: Vec, pull: Vec, end: Vec, points: Int)
        = QuadraticBeizerCurveRenderer(points, start, pull, end)

    fun fixedRectangle(from: Vec, to: Vec, step: Double = 0.1) = rectangle(from.max(to).sub(from.min(to)), step)
        .translate(from.min(to))

    fun line(vector: Vec, step: Double = 0.1) = LineRenderer(vector, step)

    fun polygon(points: Iterable<Vec>, step: Double = 0.1) = PolygonRenderer(points.asSequence(), step)
    fun polygon(vararg points: Vec,  step: Double = 0.1) = PolygonRenderer(points.asSequence(), step)

    fun circle(radius: Double, divisions: Int = (2 * PI / asin(0.1 / radius)).toInt()) =
        CircleRenderer(radius, divisions)

    fun filledCircle(radius: Double, innerDivisions: Int = (radius * 10).toInt(), particleSpacing: Double = 0.1) =
        FilledCircleRenderer(radius, innerDivisions, particleSpacing)

    fun sphere(particles: Int = 50) = SphereRenderer(particles)
    fun sphere(radius: Double, particles: Int = 50) = SphereRenderer(particles).expand(radius)
}