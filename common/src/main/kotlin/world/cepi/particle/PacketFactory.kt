@file:Suppress("unused")

package world.cepi.particle

import net.minestom.server.coordinate.Vec
import net.minestom.server.network.packet.server.play.ParticlePacket
import net.minestom.server.utils.binary.BinaryWriter
import net.minestom.server.particle.Particle as MinestomParticle
import java.util.*

object PacketFactory {

    private val ids = MinestomParticle.values().associate { it.namespace() to it.id() }

    fun createParticlePackets(particle: Particle<*, *>, renderer: Iterable<Vec>): Collection<ParticlePacket> =
        renderer.map { createParticlePacket(particle, it) }

    fun createParticlePackets(particle: Particle<*, *>, renderer: Vec): Collection<ParticlePacket> =
        Collections.singleton(createParticlePacket(particle, renderer))

    fun createParticlePacket(particle: Particle<*, *>, renderer: Vec) = ParticlePacket().apply {
        particleId = (ids[particle.name] ?: 0).toInt()
        longDistance = particle.longDistance

        x = renderer.x()
        y = renderer.y()
        z = renderer.z()

        val (offX, offY, offZ, extra) = particle.particleData
        offsetX = offX
        offsetY = offY
        offsetZ = offZ

        particleData = extra
        particleCount = particle.count

        data = when (val extraData = particle.extraData) {
            is ParticleTypes.BinaryData ->
                BinaryWriter().also { extraData.accept(it) }.toByteArray()
            else -> ByteArray(0)
        }
    }

}