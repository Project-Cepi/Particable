package world.cepi.particle.util

import net.minestom.server.utils.Vector

class Vectors(private val start: Vector, private val end: Vector, private val step: Double) : Iterable<Vector> {
    private val distSqr = end.distanceSquared(start)
    private val addVec: Vector
    init {
        val v = Vector(end.x - start.x, end.y - start.y, end.z - start.z)
        v.normalizeFast()
        v.multiply(step)
        addVec = v
    }

    override fun iterator(): Iterator<Vector> = VectorIterator()

    inner class VectorIterator : Iterator<Vector> {
        private val current = start.clone()
        private var currentDist = .0
        private inline val currentDistSqr get() = currentDist * currentDist
        private var ended = false

        override fun hasNext(): Boolean = !ended

        override fun next(): Vector {
            currentDist += step
            if (currentDistSqr != distSqr && currentDistSqr > distSqr) ended = true
            if (ended) return end
            current.add(addVec.x, addVec.y, addVec.z)
            return current.clone()
        }
    }
}

private fun Vector.normalizeFast() {
    var x = lengthSquared()

    // Fast inverse square root
    val xHalf = .5 * x
    var i = x.toRawBits()
    i = 0x5fe6ec85e7de30daL - (i ushr 1)
    x = Double.fromBits(i)
    x *= (1.5 - xHalf * x * x)

    multiply(x)
}