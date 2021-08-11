@file:Suppress("ClassName")

package world.cepi.particle

import net.kyori.adventure.key.Keyed
import net.minestom.server.utils.binary.BinaryWriter
import world.cepi.particle.data.Color
import world.cepi.particle.data.OffsetAndSpeed
import world.cepi.particle.extra.*
import world.cepi.particle.extra.Nothing
import java.util.function.Consumer
import net.minestom.server.particle.Particle as MinestomParticle

internal sealed class ParticleTypes <D : Particle.Data, E : Particle.ExtraData?>
constructor(private val minestomParticle: MinestomParticle) :
    Particle.Type<D, E>, Keyed by minestomParticle {

    internal class Default(minestomParticle: MinestomParticle) :
        ParticleTypes<OffsetAndSpeed, Nothing?>(minestomParticle)

    internal class Colored(minestomParticle: MinestomParticle) :
        ParticleTypes<Color, Nothing?>(minestomParticle)

    internal fun interface BinaryData : Particle.ExtraData, Consumer<BinaryWriter>

    // Internal stuff
    internal class Block(minestomParticle: MinestomParticle) : ParticleTypes<OffsetAndSpeed, BlockState>(minestomParticle)
    internal object DUST : ParticleTypes<OffsetAndSpeed, Dust>(MinestomParticle.DUST)
    internal object DUST_COLOR_TRANSITION : ParticleTypes<OffsetAndSpeed, DustTransition>(MinestomParticle.DUST_COLOR_TRANSITION)
    internal object ITEM : ParticleTypes<OffsetAndSpeed, Item>(MinestomParticle.ITEM)
    internal object VIBRATION : ParticleTypes<OffsetAndSpeed, Vibration>(MinestomParticle.VIBRATION)
}