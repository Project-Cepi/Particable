package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.PointSequence
import world.cepi.particle.util.x
import world.cepi.particle.util.y
import world.cepi.particle.util.z
import kotlin.math.pow

class QuadraticBeizerCurveRenderer(
    val points: Int = 20,
    val start: Point,
    val pull: Point,
    val end: Point
) : PointSequence {

    /**
     * @param k A number from 0 - 1
     */
    fun getAxis(start: Double, pull: Double, end: Double, k: Double): Double {
        return ((1 - k).pow(2.0) * start) + ((1 - k) * k * pull) + (k.pow(2) * end)
    }

    override fun iterator() = run {
        (0..points).map { it.toDouble() / points }.map {
            Vec(
                getAxis(start.x, pull.x, end.x, it),
                getAxis(start.y, pull.y, end.y, it),
                getAxis(start.z, pull.z, end.z, it)
            )
        }
    }.iterator()

}