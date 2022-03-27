@file:Suppress("unused")

package world.cepi.particle

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import net.minestom.server.network.packet.server.play.ParticlePacket
import net.minestom.server.utils.binary.BinaryWriter
import net.minestom.server.particle.Particle as MinestomParticle
import java.util.*

object PacketFactory {

    private val ids = MinestomParticle.values().associate { it.namespace() to it.id() }

    fun createParticlePackets(particle: Particle<*, *>, renderer: Iterable<Point>): Collection<ParticlePacket> =
        renderer.map { createParticlePacket(particle, it) }

    fun createParticlePackets(particle: Particle<*, *>, renderer: Sequence<Point>): Collection<ParticlePacket> =
        renderer.map { createParticlePacket(particle, it) }.toList()

    fun createParticlePackets(particle: Particle<*, *>, renderer: Point): Collection<ParticlePacket> =
        Collections.singleton(createParticlePacket(particle, renderer))

    fun createParticlePacket(particle: Particle<*, *>, renderer: Point) = ParticlePacket(
        ids[particle.name] ?: 0,
        particle.longDistance,

        renderer.x(),
        renderer.y(),
        renderer.z(),

        particle.particleData.component1(),
        particle.particleData.component2(),
        particle.particleData.component3(),

        particle.particleData.component4(),
        particle.count,
        
        when (val extraData = particle.extraData) {
            is ParticleTypes.BinaryData ->
                BinaryWriter().also { extraData.accept(it) }.toByteArray()
            else -> ByteArray(0)
        }
    )

}