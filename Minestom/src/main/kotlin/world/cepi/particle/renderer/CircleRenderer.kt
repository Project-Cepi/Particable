package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

data class CircleRenderer(
    val center: Position,
    val radius: Double,
    val axis: Axis,
    val divisions: Int
) : Renderer {
    private val step = (2 * PI / divisions)
    private val radians = DoubleArray(divisions) { i -> step * i }
    private val xs = DoubleArray(divisions) { i -> cos(radians[i]) * radius }
    private val ys = DoubleArray(divisions) { i -> sin(radians[i]) * radius }

    override fun iterator(): kotlin.collections.Iterator<Position> = Iterator()

    inner class Iterator : kotlin.collections.Iterator<Position> {
        private var d = 0

        override fun hasNext() = d < divisions

        override fun next(): Position {
            val res = when (axis) {
                Axis.XY -> Position(xs[d], ys[d], .0)
                Axis.XZ -> Position(xs[d], .0, ys[d])
                Axis.YZ -> Position(.0, xs[d], ys[d])
            }
            res.add(center)
            ++d
            return res
        }
    }

    enum class Axis {
        XY, XZ, YZ
    }
}

