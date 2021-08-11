import net.kyori.adventure.audience.Audience
import net.minestom.server.utils.Position
import world.cepi.particle.Particle
import world.cepi.particle.ParticleType
import world.cepi.particle.Renderer
import world.cepi.particle.data.Color
import world.cepi.particle.renderer.SphereRenderer
import world.cepi.particle.showParticle

fun main() {
    val lr = SphereRenderer(Position(), 1.0, 0.5)
    lr.forEach { println(it) }
    (object : Audience {})
        .showParticle(Particle.particle(ParticleType.AMBIENT_ENTITY_EFFECT, 5, Color(1f, 0f, 0f, 1f)), Renderer.point(Position()))
}