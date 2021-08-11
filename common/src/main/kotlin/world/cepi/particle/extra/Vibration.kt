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
    override fun accept(binaryWriter: BinaryWriter) {
        binaryWriter.writeFloat(startX)
        binaryWriter.writeFloat(startY)
        binaryWriter.writeFloat(startZ)
        binaryWriter.writeFloat(endX)
        binaryWriter.writeFloat(endY)
        binaryWriter.writeFloat(endZ)
        binaryWriter.writeInt(ticks)
    }
}