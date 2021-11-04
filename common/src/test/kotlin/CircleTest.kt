import net.minestom.server.adventure.audience.Audiences
import net.minestom.server.coordinate.Vec
import world.cepi.particle.Particle
import world.cepi.particle.ParticleType
import world.cepi.particle.data.OffsetAndSpeed
import world.cepi.particle.showParticle

fun main() {

    val particle = Particle.particle(
        ParticleType.CLOUD,
        5,
        OffsetAndSpeed(.0f, .0f, .0f, .0f)
    )

    Audiences.players().showParticle(particle, Vec.ZERO)

}