@file:Suppress("Unused", "OverrideOnly")

package world.cepi.particle

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.minestom.server.adventure.audience.PacketGroupingAudience
import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import net.minestom.server.entity.Player
import world.cepi.particle.renderer.PointIterable
import world.cepi.particle.renderer.PointSequence

fun <D : Particle.Data, E : Particle.ExtraData> Audience.showParticle(particle: Particle<D, E>, renderer: PointSequence) {
    when (this) {
        is PacketGroupingAudience -> showParticle(particle, renderer)
        is ForwardingAudience.Single -> showParticle(particle, renderer)
        is ForwardingAudience -> showParticle(particle, renderer)
        is Player -> showParticle(particle, renderer)
    }
}

fun <D : Particle.Data, E : Particle.ExtraData> Audience.showParticle(particle: Particle<D, E>, renderer: PointIterable)
    = this.showParticle(particle, renderer.asSequence())

fun <D : Particle.Data, E : Particle.ExtraData> Audience.showParticle(particle: Particle<D, E>, renderer: Point) {
    when (this) {
        is PacketGroupingAudience -> showParticle(particle, renderer)
        is ForwardingAudience.Single -> showParticle(particle, renderer)
        is ForwardingAudience -> showParticle(particle, renderer)
        is Player -> showParticle(particle, renderer)
    }
}

fun <D : Particle.Data, E : Particle.ExtraData> ForwardingAudience.showParticle(particle: Particle<D, E>, renderer: PointSequence) {
    audiences().forEach { it.showParticle(particle, renderer) }
}

fun <D : Particle.Data, E : Particle.ExtraData> ForwardingAudience.showParticle(particle: Particle<D, E>, renderer: Point) {
    audiences().forEach { it.showParticle(particle, renderer) }
}

fun <D : Particle.Data, E : Particle.ExtraData> PacketGroupingAudience.showParticle(particle: Particle<D, E>, renderer: PointSequence) {
    PacketFactory.createParticlePackets(particle, renderer).forEach(this::sendGroupedPacket)
}

fun <D : Particle.Data, E : Particle.ExtraData> PacketGroupingAudience.showParticle(particle: Particle<D, E>, renderer: Point) {
    sendGroupedPacket(PacketFactory.createParticlePacket(particle, renderer))
}

fun <D : Particle.Data, E : Particle.ExtraData> Player.showParticle(particle: Particle<D, E>, renderer: PointSequence) {
    PacketFactory.createParticlePackets(particle, renderer).forEach(playerConnection::sendPacket)
}

fun <D : Particle.Data, E : Particle.ExtraData> Player.showParticle(particle: Particle<D, E>, renderer: Vec) {
    playerConnection.sendPacket(PacketFactory.createParticlePacket(particle, renderer))
}

fun <D : Particle.Data, E : Particle.ExtraData> ForwardingAudience.Single.showParticle(particle: Particle<D, E>, renderer: PointSequence) {
    audience().showParticle(particle, renderer)
}

fun <D : Particle.Data, E : Particle.ExtraData> ForwardingAudience.Single.showParticle(particle: Particle<D, E>, renderer: Vec) {
    audience().showParticle(particle, renderer)
}