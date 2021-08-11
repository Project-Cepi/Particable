@file:Suppress("unused")

package world.cepi.particle

import net.minestom.server.network.packet.server.play.ParticlePacket
import net.minestom.server.utils.Vector
import net.minestom.server.utils.binary.BinaryWriter
import world.cepi.particle.renderer.Renderer
import net.minestom.server.particle.Particle as MinestomParticle
import java.util.*

object PacketFactory {

    private val ids = MinestomParticle.values().associate { it.namespaceID to it.id }

    fun createParticlePackets(particle: Particle<*, *>, renderer: Particle.Renderer): Collection<ParticlePacket> =
        if (renderer is Renderer) renderer.map { createParticlePacket(particle, it) }
        else emptyList()

    fun createParticlePackets(particle: Particle<*, *>, renderer: Vector): Collection<ParticlePacket> =
        Collections.singleton(createParticlePacket(particle, renderer))

    fun createParticlePacket(particle: Particle<*, *>, renderer: Vector): ParticlePacket {
        val packet = ParticlePacket()
        packet.particleId = (ids[particle.name] ?: 0).toInt()
        packet.longDistance = particle.longDistance

        packet.x = renderer.x
        packet.y = renderer.y
        packet.z = renderer.z

        val (offX, offY, offZ, extra) = particle.particleData
        packet.offsetX = offX
        packet.offsetY = offY
        packet.offsetZ = offZ

        packet.particleData = extra
        packet.particleCount = particle.count

        packet.data = when (val e = particle.extraData) {
            is ParticleTypes.BinaryData -> {
                val writer = BinaryWriter()
                e.accept(writer)
                writer.toByteArray()
            }
            else -> ByteArray(0)
        }

        return packet
    }
}