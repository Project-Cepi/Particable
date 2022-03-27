package world.cepi.particle.util

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec

val Point.x get() = this.x()
val Point.y get() = this.y()
val Point.z get() = this.z()

operator fun Point.plus(v: Point) = Vec(x + v.x, y + v.y, z + v.z)
operator fun Point.minus(v: Point) = Vec(x - v.x, y - v.y, z - v.z)
operator fun Point.times(v: Point) = Vec(x * v.x, y * v.y, z * v.z)
operator fun Point.rem(v: Point) = Vec(x % v.x, y % v.y, z % v.z)

operator fun Point.plus(xyz: Double) = Vec(x + xyz, y + xyz, z + xyz)
operator fun Point.minus(xyz: Double) = Vec(x - xyz, y - xyz, z - xyz)
operator fun Point.times(xyz: Double) = Vec(x * xyz, y * xyz, z * xyz)
operator fun Point.rem(xyz: Double) = Vec(x % xyz, y % xyz, z % xyz)

operator fun Point.compareTo(v: Point) = lengthSquared().compareTo(v.lengthSquared())

operator fun Point.unaryPlus() = Vec(x, y, z)
operator fun Point.unaryMinus() = Vec(-x, -y, -z)

operator fun Point.rangeTo(v: Vec) = VectorsBuilder(this, v)

operator fun Point.component1() = x
operator fun Point.component2() = y
operator fun Point.component3() = z

operator fun Point.get(index: Int) = when (index) {
    0 -> x
    1 -> y
    2 -> z
    else -> throw IllegalArgumentException("Index must be between 0 and 2")
}

operator fun Point.set(index: Int, value: Double): Point {
    return when (index) {
        0 -> withX(value)
        1 -> withY(value)
        2 -> withZ(value)
        else -> throw IllegalArgumentException("Index must be between 0 and 2")
    }
}