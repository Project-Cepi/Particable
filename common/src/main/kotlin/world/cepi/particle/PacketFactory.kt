@file:Suppress("unused")

package world.cepi.particle

import it.unimi.dsi.fastutil.objects.Object2ShortArrayMap
import it.unimi.dsi.fastutil.objects.Object2ShortMap
import net.kyori.adventure.key.Key
import net.minestom.server.network.packet.server.play.ParticlePacket
import net.minestom.server.utils.Position
import net.minestom.server.utils.binary.BinaryWriter
import java.util.*

object PacketFactory {
    fun createParticlePackets(particle: Particle<*, *>, renderer: Particle.Renderer): Collection<ParticlePacket> =
        if (renderer is Renderer) renderer.map { createParticlePacket(particle, it) }
        else emptyList()

    fun createParticlePackets(particle: Particle<*, *>, renderer: Position): Collection<ParticlePacket> =
        Collections.singleton(createParticlePacket(particle, renderer))

    fun createParticlePacket(particle: Particle<*, *>, renderer: Position): ParticlePacket {
        val packet = ParticlePacket()
        packet.particleId = ids.getShort(particle.name).toInt()
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

private val ids: Object2ShortMap<Key> = Object2ShortArrayMap<Key>(net.minestom.server.particle.Particle.values().size).apply {
    for (v in net.minestom.server.particle.Particle.values()) {
        put(v.namespaceID, v.id)
    }
}