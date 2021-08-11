@file:Suppress("unused", "unused")

package world.cepi.particle

import net.kyori.adventure.audience.Audience

fun <D : Particle.Data, E : Particle.ExtraData?> Audience.showParticle(particle: Particle<D, E>, renderer: Particle.Renderer) {
    error("Not implemented without an API")
}