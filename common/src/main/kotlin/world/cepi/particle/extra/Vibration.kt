package world.cepi.particle.extra

import net.minestom.server.utils.binary.BinaryWriter
import world.cepi.particle.ParticleTypes

data class Vibration(
    val startX: Float,
    val startY: Float,
    val startZ: Float,
    val endX: Float,
    val endY: Float,
    val endZ: Float,
    val ticks: Int
) : ParticleTypes.BinaryData {
    override fun accept(t: BinaryWriter) {
        t.writeFloat(startX)
        t.writeFloat(startY)
        t.writeFloat(startZ)
        t.writeFloat(endX)
        t.writeFloat(endY)
        t.writeFloat(endZ)
        t.writeInt(ticks)
    }
}