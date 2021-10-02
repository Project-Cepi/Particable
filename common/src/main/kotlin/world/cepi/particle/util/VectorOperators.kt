package world.cepi.particle.util

import net.minestom.server.coordinate.Vec

val Vec.x get() = this.x()
val Vec.y get() = this.y()
val Vec.z get() = this.z()

operator fun Vec.plus(v: Vec) = Vec(x + v.x, y + v.y, z + v.z)
operator fun Vec.minus(v: Vec) = Vec(x - v.x, y - v.y, z - v.z)
operator fun Vec.times(v: Vec) = Vec(x * v.x, y * v.y, z * v.z)
operator fun Vec.rem(v: Vec) = Vec(x % v.x, y % v.y, z % v.z)

operator fun Vec.plus(xyz: Double) = Vec(x + xyz, y + xyz, z + xyz)
operator fun Vec.minus(xyz: Double) = Vec(x - xyz, y - xyz, z - xyz)
operator fun Vec.times(xyz: Double) = Vec(x * xyz, y * xyz, z * xyz)
operator fun Vec.rem(xyz: Double) = Vec(x % xyz, y % xyz, z % xyz)

operator fun Vec.compareTo(v: Vec) = lengthSquared().compareTo(v.lengthSquared())

operator fun Vec.unaryPlus() = Vec(x, y, z)
operator fun Vec.unaryMinus() = Vec(-x, -y, -z)

operator fun Vec.rangeTo(v: Vec) = VectorsBuilder(this, v)

operator fun Vec.component1() = x
operator fun Vec.component2() = y
operator fun Vec.component3() = z

operator fun Vec.get(index: Int) = when (index) {
    0 -> x
    1 -> y
    2 -> z
    else -> throw IllegalArgumentException("Index must be between 0 and 2")
}

operator fun Vec.set(index: Int, value: Double): Vec {
    return when (index) {
        0 -> withX(value)
        1 -> withY(value)
        2 -> withZ(value)
        else -> throw IllegalArgumentException("Index must be between 0 and 2")
    }
}