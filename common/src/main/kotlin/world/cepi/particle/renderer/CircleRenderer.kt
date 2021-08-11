package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.Renderer
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

data class CircleRenderer(
    val radius: Double,
    val axis: Axis,
    val divisions: Int
) : Renderer {
    private val step = (2 * PI / divisions)
    private val radians = DoubleArray(divisions) { i -> step * i }
    private val xs = DoubleArray(divisions) { i -> cos(radians[i]) * radius }
    private val ys = DoubleArray(divisions) { i -> sin(radians[i]) * radius }

    override fun iterator(): Iterator<Vector> = ParticleIterator()

    inner class ParticleIterator : Iterator<Vector> {
        private var d = 0

        override fun hasNext() = d < divisions

        override fun next(): Vector {
            val res = when (axis) {
                Axis.XY -> Vector(xs[d], ys[d], .0)
                Axis.XZ -> Vector(xs[d], .0, ys[d])
                Axis.YZ -> Vector(.0, xs[d], ys[d])
            }
            ++d
            return res
        }
    }

    enum class Axis {
        XY, XZ, YZ
    }
}

