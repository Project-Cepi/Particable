package world.cepi.particle.extra

import net.minestom.server.utils.binary.BinaryWriter
import world.cepi.particle.ParticleTypes

data class DustTransition(
    val fromRed: Float,
    val fromGreen: Float,
    val fromBlue: Float,
    val toRed: Float,
    val toGreen: Float,
    val toBlue: Float,
    val scale: Float
) : ParticleTypes.BinaryData {
    override fun accept(binaryWriter: BinaryWriter) {
        binaryWriter.writeFloat(fromRed)
        binaryWriter.writeFloat(fromGreen)
        binaryWriter.writeFloat(fromBlue)
        binaryWriter.writeFloat(scale)
        binaryWriter.writeFloat(toRed)
        binaryWriter.writeFloat(toGreen)
        binaryWriter.writeFloat(toBlue)
    }
}