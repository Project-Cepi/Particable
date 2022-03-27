package world.cepi.particle.renderer

import net.kyori.adventure.audience.Audience
import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import world.cepi.particle.Particle
import world.cepi.particle.showParticle

typealias PointIterable = Iterable<Point>
typealias PointSequence = Sequence<Point>

fun PointSequence.expand(amount: Double) = this.map { it.mul(amount) }
fun PointSequence.translate(translationVec: Vec) = this.map { it.add(translationVec) }

fun PointSequence.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this)

fun PointIterable.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this)

fun Point.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this)

fun Array<Vec>.render(particle: Particle<*, *>, audience: Audience) = audience.showParticle(particle, this.asSequence())