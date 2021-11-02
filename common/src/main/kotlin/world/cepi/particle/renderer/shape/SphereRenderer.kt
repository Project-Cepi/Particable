package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.renderer.VecIterable
import java.awt.Shape
import java.util.*
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class SphereRenderer(
    val radius: Double,
    val particleSpacing: Double = .2
) : VecIterable {
    private val iterable = run {
        val list = LinkedList<Vec>()
        val divisions = (2 * PI / asin(particleSpacing / radius)).toInt()

        Renderer.circle(radius, divisions).forEach(list::add)

        val da = 2 * PI / divisions
        var d = 1
        while (d < divisions / 4) {
            val radius = cos(da * d) * radius
            Renderer.circle(radius, (2 * PI / asin(particleSpacing / radius)).toInt())
                .map { it.add(Vec(.0, .0 + sin(da * d) * this.radius, .0)) }
                .forEach {
                    list.add(it)
                    list.add(Vec(it.x(), .0 - (it.y()), it.z()))
                }
            ++d
        }

        list.add(Vec(.0, .0 + radius, .0))
        list.add(Vec(.0, .0 - radius, .0))

        list
    }

    override fun iterator(): Iterator<Vec> = iterable.iterator()
}