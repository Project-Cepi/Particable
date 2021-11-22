package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.renderer.VecSequence
import java.awt.Shape
import java.util.*
import kotlin.math.*

data class SphereRenderer(
    val radius: Double,
    val particles: Int = 50 // Higher is more detailed
) : VecSequence {

    private val iterable = run {
        val list = LinkedList<Vec>()

        val phi = PI * (3.0 - sqrt(5.0))

        repeat(particles) {
            val y = 1.0 - (it / (particles - 1.0)) * 2.0
            val yRadius = sqrt(1.0 - y * y)
            val theta = phi * it
            val x = cos(theta) * yRadius
            val z = sin(theta) * yRadius

            list.add(Vec(x * radius, y * radius, z * radius))
        }

        list
    }

    override fun iterator(): Iterator<Vec> = iterable.iterator()
}