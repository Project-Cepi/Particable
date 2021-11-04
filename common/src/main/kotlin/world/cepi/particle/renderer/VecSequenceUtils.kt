package world.cepi.particle.renderer

import net.kyori.adventure.audience.Audience
import net.minestom.server.coordinate.Vec
import world.cepi.particle.Particle
import world.cepi.particle.showParticle

typealias VecIterable = Iterable<Vec>
typealias VecSequence = Sequence<Vec>

fun VecSequence.translate(translationVec: Vec) = this.map { it.add(translationVec) }

fun VecSequence.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this)

fun VecIterable.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this)

fun Vec.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this)

fun Array<Vec>.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this.asSequence())