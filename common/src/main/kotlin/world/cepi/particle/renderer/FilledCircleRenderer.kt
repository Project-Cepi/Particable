package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer
import java.util.*
import kotlin.math.PI
import kotlin.math.asin

data class FilledCircleRenderer(
    val center: Position,
    val radius: Double,
    val axis: CircleRenderer.Axis,
    val innerDivisions: Int,
    val particleSpacing: Double
) : Renderer {
    private val iterable = run {
        val smallestR = radius / innerDivisions
        val list = LinkedList<Position>()
        var d = 0
        while (d < innerDivisions) {
            val r = smallestR * (d + 1)
            CircleRenderer(center, r, axis, (2 * PI / asin(particleSpacing / r)).toInt())
                .forEach(list::add)
            ++d
        }
        list
    }

    override fun iterator(): Iterator<Position> = iterable.iterator()
}