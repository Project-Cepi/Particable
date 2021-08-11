@file:Suppress("Unused", "OverrideOnly")

package world.cepi.particle

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.minestom.server.adventure.audience.PacketGroupingAudience
import net.minestom.server.entity.Player
import net.minestom.server.utils.Position

fun <D : Particle.Data, E : Particle.ExtraData?> Audience.showParticle(particle: Particle<D, E>, renderer: Particle.Renderer) {
    when (this) {
        is PacketGroupingAudience -> showParticle(particle, renderer)
        is ForwardingAudience.Single -> showParticle(particle, renderer)
        is ForwardingAudience -> showParticle(particle, renderer)
        is Player -> showParticle(particle, renderer)
    }
}

fun <D : Particle.Data, E : Particle.ExtraData?> Audience.showParticle(particle: Particle<D, E>, renderer: Position) {
    when (this) {
        is PacketGroupingAudience -> showParticle(particle, renderer)
        is ForwardingAudience.Single -> showParticle(particle, renderer)
        is ForwardingAudience -> showParticle(particle, renderer)
        is Player -> showParticle(particle, renderer)
    }
}

fun <D : Particle.Data, E : Particle.ExtraData?> ForwardingAudience.showParticle(particle: Particle<D, E>, renderer: Particle.Renderer) {
    audiences().forEach { it.showParticle(particle, renderer) }
}

fun <D : Particle.Data, E : Particle.ExtraData?> ForwardingAudience.showParticle(particle: Particle<D, E>, renderer: Position) {
    audiences().forEach { it.showParticle(particle, renderer) }
}

fun <D : Particle.Data, E : Particle.ExtraData?> PacketGroupingAudience.showParticle(particle: Particle<D, E>, renderer: Particle.Renderer) {
    PacketFactory.createParticlePackets(particle, renderer).forEach(this::sendGroupedPacket)
}

fun <D : Particle.Data, E : Particle.ExtraData?> PacketGroupingAudience.showParticle(particle: Particle<D, E>, renderer: Position) {
    sendGroupedPacket(PacketFactory.createParticlePacket(particle, renderer))
}

fun <D : Particle.Data, E : Particle.ExtraData?> Player.showParticle(particle: Particle<D, E>, renderer: Particle.Renderer) {
    PacketFactory.createParticlePackets(particle, renderer).forEach(playerConnection::sendPacket)
}

fun <D : Particle.Data, E : Particle.ExtraData?> Player.showParticle(particle: Particle<D, E>, renderer: Position) {
    playerConnection.sendPacket(PacketFactory.createParticlePacket(particle, renderer))
}

fun <D : Particle.Data, E : Particle.ExtraData?> ForwardingAudience.Single.showParticle(particle: Particle<D, E>, renderer: Particle.Renderer) {
    audience().showParticle(particle, renderer)
}

fun <D : Particle.Data, E : Particle.ExtraData?> ForwardingAudience.Single.showParticle(particle: Particle<D, E>, renderer: Position) {
    audience().showParticle(particle, renderer)
}