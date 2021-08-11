package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.Renderer
import java.util.*
import kotlin.math.PI
import kotlin.math.asin

data class FilledCircleRenderer(
    val radius: Double,
    val innerDivisions: Int,
    val particleSpacing: Double
) : Renderer {
    private val iterable = run {
        val smallestR = radius / innerDivisions
        val list = LinkedList<Vector>()
        var d = 0
        while (d < innerDivisions) {
            val radius = smallestR * (d + 1)
            CircleRenderer(radius, (2 * PI / asin(particleSpacing / radius)).toInt())
                .forEach(list::add)
            ++d
        }
        list
    }

    override fun iterator(): Iterator<Vector> = iterable.iterator()
}