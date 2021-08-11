package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer
import java.util.*
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class SphereRenderer(
    val radius: Double,
    val particleSpacing: Double
) : Renderer {
    private val iterable = run {
        val list = LinkedList<Position>()
        val divisions = (2 * PI / asin(particleSpacing / radius)).toInt()

        CircleRenderer(radius, CircleRenderer.Axis.XZ, divisions).forEach(list::add)

        val da = 2 * PI / divisions
        var d = 1
        while (d < divisions / 4) {
            val radius = cos(da * d) * radius
            CircleRenderer(radius, CircleRenderer.Axis.XZ, (2 * PI / asin(particleSpacing / radius)).toInt())
                .map { it.add(Position(.0, .0 + sin(da * d) * this.radius, .0)) }
                .forEach {
                    list.add(it)
                    list.add(Position(it.x, .0 - (it.y), it.z))
                }
            ++d
        }

        list.add(Position(.0, .0 + radius, .0))
        list.add(Position(.0, .0 - radius, .0))

        list
    }

    override fun iterator(): Iterator<Position> = iterable.iterator()
}