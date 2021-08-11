package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer
import java.util.*
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class SphereRenderer(
    val center: Position,
    val radius: Double,
    val particleSpacing: Double
) : Renderer {
    private val iterable = run {
        val list = LinkedList<Position>()
        val divisions = (2 * PI / asin(particleSpacing / radius)).toInt()

        CircleRenderer(center, radius, CircleRenderer.Axis.XZ, divisions).forEach(list::add)

        val da = 2 * PI / divisions
        var d = 1
        while (d < divisions / 4) {
            val r = cos(da * d) * radius
            CircleRenderer(
                Position(center.x, center.y + sin(da * d) * radius, center.z),
                r, CircleRenderer.Axis.XZ, (2 * PI / asin(particleSpacing / r)).toInt()
            ).forEach {
                list.add(it)
                list.add(Position(it.x, center.y - (it.y - center.y), it.z))
            }
            ++d
        }

        list.add(Position(center.x, center.y + radius, center.z))
        list.add(Position(center.x, center.y - radius, center.z))

        list
    }

    override fun iterator(): Iterator<Position> = iterable.iterator()
}