package world.cepi.particle.util

import net.minestom.server.coordinate.Vec

class Vectors(private val start: Vec, private val end: Vec, private val step: Double) : Iterable<Vec> {
    private val distSqr = end.distanceSquared(start)
    private val addVec = Vec(end.x() - start.x(), end.y() - start.y(), end.z() - start.z())
        .normalizeFast()
        .mul(step)

    override fun iterator(): Iterator<Vec> = VectorIterator()

    inner class VectorIterator : Iterator<Vec> {
        private var current = start
        private var currentDist = .0
        private val currentDistSqr get() = currentDist * currentDist
        private var ended = false

        override fun hasNext(): Boolean = !ended

        override fun next(): Vec {
            currentDist += step
            if (currentDistSqr != distSqr && currentDistSqr > distSqr) ended = true
            if (ended) return end
            current = current.add(addVec.x(), addVec.y(), addVec.z())
            return current
        }
    }
}

class VectorsBuilder internal constructor(private val start: Vec, private val end: Vec) {
    infix fun step(step: Double) = Vectors(start, end, step)
}

private fun Vec.normalizeFast(): Vec {
    var x = lengthSquared()

    // Fast inverse square root
    val xHalf = .5 * x
    var i = x.toRawBits()
    i = 0x5fe6ec85e7de30daL - (i ushr 1)
    x = Double.fromBits(i)
    x *= (1.5 - xHalf * x * x)

    return mul(x)
}