package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import java.util.*
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class SphereRenderer(
    val radius: Double,
    val particleSpacing: Double = .2
) : Renderer {
    private val iterable = run {
        val list = LinkedList<Vector>()
        val divisions = (2 * PI / asin(particleSpacing / radius)).toInt()

        Renderer.circle(radius, divisions).forEach(list::add)

        val da = 2 * PI / divisions
        var d = 1
        while (d < divisions / 4) {
            val radius = cos(da * d) * radius
            Renderer.circle(radius, (2 * PI / asin(particleSpacing / radius)).toInt())
                .map { it.add(Vector(.0, .0 + sin(da * d) * this.radius, .0)) }
                .forEach {
                    list.add(it)
                    list.add(Vector(it.x, .0 - (it.y), it.z))
                }
            ++d
        }

        list.add(Vector(.0, .0 + radius, .0))
        list.add(Vector(.0, .0 - radius, .0))

        list
    }

    override fun iterator(): Iterator<Vector> = iterable.iterator()
}