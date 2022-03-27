package world.cepi.particle.util

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import kotlin.math.pow

class Points(private val start: Point, private val end: Point, private val step: Double) : Iterable<Point> {
    private val distSqr = end.distanceSquared(start)
    private val addVec = Vec(end.x() - start.x(), end.y() - start.y(), end.z() - start.z())
        .normalizeFast()
        .mul(step)

    override fun iterator(): Iterator<Point> = PointIterator()

    inner class PointIterator : Iterator<Point> {
        private var current = start
        private var currentDist = .0
        private val currentDistSqr get() = currentDist * currentDist
        private var ended = false

        override fun hasNext(): Boolean = !ended

        override fun next(): Point {
            currentDist += step
            if (currentDistSqr != distSqr && currentDistSqr > distSqr) ended = true
            if (ended) return end
            current = current.add(addVec.x(), addVec.y(), addVec.z())
            return current
        }
    }
}

class VectorsBuilder internal constructor(private val start: Point, private val end: Point) {
    infix fun step(step: Double) = Points(start, end, step)
}

internal fun Point.lengthSquared(): Double = x.pow(2) + y.pow(2) + z.pow(2)

private fun Point.normalizeFast(): Point {
    var x = lengthSquared()

    // Fast inverse square root
    val xHalf = .5 * x
    var i = x.toRawBits()
    i = 0x5fe6ec85e7de30daL - (i ushr 1)
    x = Double.fromBits(i)
    x *= (1.5 - xHalf * x * x)

    return mul(x)
}