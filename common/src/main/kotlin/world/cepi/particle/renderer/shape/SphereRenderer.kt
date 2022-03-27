package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.PointSequence
import kotlin.math.*

data class SphereRenderer(
    /** The higher it is the more detailed it is. */
    val particles: Int = 50
) : PointSequence {

    companion object {
        val phi = PI * (3.0 - sqrt(5.0))
    }

    private val iterable = object : Iterator<Point> {

        var particleCount = 0

        override fun hasNext() = particles >= particleCount

        override fun next(): Vec {
            val y = 1.0 - (particleCount / (particles - 1.0)) * 2.0
            val yRadius = sqrt(1.0 - y * y)
            val theta = phi * particleCount

            return Vec(
                cos(theta) * yRadius,
                y,
                sin(theta) * yRadius
            )
        }
    }

    override fun iterator(): Iterator<Point> = iterable.iterator()
}