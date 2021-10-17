package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import java.util.*
import kotlin.math.PI
import kotlin.math.asin

data class FilledCircleRenderer(
    val radius: Double,
    val innerDivisions: Int = (radius * 10).toInt(),
    val particleSpacing: Double = .1
) : Renderer.Shape() {
    override fun iterator(): Iterator<Vec> = run {
        val smallestR = radius / innerDivisions
        val list = LinkedList<Vec>()
        var d = 0
        while (d < innerDivisions) {
            val radius = smallestR * (d + 1)
            CircleRenderer(radius, (2 * PI / asin(particleSpacing / radius)).toInt())
                .forEach(list::add)
            ++d
        }
        list
    }.iterator()
}