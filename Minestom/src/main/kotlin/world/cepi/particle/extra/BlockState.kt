package world.cepi.particle.extra

import net.minestom.server.instance.block.Block
import net.minestom.server.utils.binary.BinaryWriter
import world.cepi.particle.ParticleTypes

@JvmInline
value class BlockState(private val block: Block) : ParticleTypes.BinaryData {
    override fun accept(t: BinaryWriter) {
        t.writeVarInt(block.blockId.toInt())
    }
}