package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import java.util.*
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class SphereRenderer(
    val radius: Double,
    val particleSpacing: Double = .2
) : Renderer.Shape() {

    inner class SphereIterator : Iterator<Vec> {

        val list = run {
            val divisions = (2 * PI / asin(particleSpacing / radius)).toInt()
            val list = Renderer.circle(radius, divisions).toMutableList()

            val da = 2 * PI / divisions
            var d = 1
            while (d < divisions / 4) {
                val radius = cos(da * d) * radius
                Renderer.circle(radius, (2 * PI / asin(particleSpacing / radius)).toInt())
                    .map { it.add(Vec(.0, .0 + sin(da * d) * radius, .0)) }
                    .forEach {
                        list.add(it)
                        list.add(Vec(it.x(), -(it.y()), it.z()))
                    }
                ++d
            }

            list.add(Vec(.0, .0 + radius, .0))
            list.add(Vec(.0, .0 - radius, .0))

            list
        }

        var index = 0

        override fun hasNext() = index + 1 < list.size
        override fun next(): Vec {
            return list[index].also { index++ }
        }
    }

    override fun iterator(): Iterator<Vec> = SphereIterator()
}