package world.cepi.particle.extra

import net.minestom.server.utils.binary.BinaryWriter
import world.cepi.particle.ParticleTypes

data class Dust(
    val red: Float,
    val green: Float,
    val blue: Float,
    val scale: Float
) : ParticleTypes.BinaryData {
    override fun accept(t: BinaryWriter) {
        t.writeFloat(red)
        t.writeFloat(green)
        t.writeFloat(blue)
        t.writeFloat(scale)
    }
}