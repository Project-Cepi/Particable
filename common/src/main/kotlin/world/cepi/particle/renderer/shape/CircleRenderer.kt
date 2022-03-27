package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.PointSequence
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class CircleRenderer(
    val radius: Double,
    val divisions: Int = (2 * PI / asin(0.1 / radius)).toInt()
) : PointSequence {
    private val step = (2 * PI / divisions)
    private val radians = DoubleArray(divisions) { i -> step * i }
    private val xs = DoubleArray(divisions) { i -> cos(radians[i]) * radius }
    private val ys = DoubleArray(divisions) { i -> sin(radians[i]) * radius }

    override fun iterator(): Iterator<Point> = ParticleIterator()

    inner class ParticleIterator : Iterator<Point> {
        private var d = 0

        override fun hasNext() = d < divisions

        override fun next() = Vec(xs[d], .0, ys[d]).also { d++ }
    }
}

