package world.cepi.particle.util

import net.minestom.server.utils.Vector

operator fun Vector.plus(v: Vector) = Vector(x + v.x, y + v.y, z + v.z)
operator fun Vector.minus(v: Vector) = Vector(x - v.x, y - v.y, z - v.z)
operator fun Vector.times(v: Vector) = Vector(x * v.x, y * v.y, z * v.z)
operator fun Vector.div(v: Vector) = Vector(x / v.x, y / v.y, z / v.z)
operator fun Vector.rem(v: Vector) = Vector(x % v.x, y % v.y, z % v.z)

operator fun Vector.plus(xyz: Double) = Vector(x + xyz, y + xyz, z + xyz)
operator fun Vector.minus(xyz: Double) = Vector(x - xyz, y - xyz, z - xyz)
operator fun Vector.times(xyz: Double) = Vector(x * xyz, y * xyz, z * xyz)
operator fun Vector.div(xyz: Double) = Vector(x / xyz, y / xyz, z / xyz)
operator fun Vector.rem(xyz: Double) = Vector(x % xyz, y % xyz, z % xyz)

operator fun Vector.plusAssign(v: Vector) { add(v) }
operator fun Vector.minusAssign(v: Vector) { subtract(v) }
operator fun Vector.timesAssign(v: Vector) { multiply(v) }
operator fun Vector.divAssign(v: Vector) { divide(v) }
operator fun Vector.remAssign(v: Vector) { x %= v.x; y %= v.y; z %= v.z }

operator fun Vector.timesAssign(xyz: Double) { multiply(xyz) }
operator fun Vector.divAssign(xyz: Double) { x /= xyz; y /= xyz; z /= xyz }
operator fun Vector.remAssign(xyz: Double) { x %= xyz; y %= xyz; z %= xyz }

operator fun Vector.compareTo(v: Vector) = lengthSquared().compareTo(v.lengthSquared())

operator fun Vector.unaryPlus() = Vector(x, y, z)
operator fun Vector.unaryMinus() = Vector(-x, -y, -z)

operator fun Vector.rangeTo(v: Vector) = VectorsBuilder(this, v)

operator fun Vector.component1() = x
operator fun Vector.component2() = y
operator fun Vector.component3() = z

operator fun Vector.get(index: Int) = when (index) {
    0 -> x
    1 -> y
    2 -> z
    else -> throw IllegalArgumentException("Index must be between 0 and 2")
}

operator fun Vector.set(index: Int, value: Double) {
    when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        else -> throw IllegalArgumentException("Index must be between 0 and 2")
    }
}