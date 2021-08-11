import net.kyori.adventure.audience.Audience
import net.minestom.server.adventure.audience.Audiences
import net.minestom.server.utils.Position
import world.cepi.particle.Particle
import world.cepi.particle.ParticleType
import world.cepi.particle.Renderer
import world.cepi.particle.data.Color
import world.cepi.particle.renderer.SphereRenderer
import world.cepi.particle.showParticle

fun main() {
    val lr =
        //LineRenderer(Position(.0, .0, .0), Position(1.0, .0, .0))
        //PolygonRenderer(Position(.0, .0, .0), Position(1.0, .0, .0), Position(1.0, 1.0, .0), Position(.0, 1.0, .0), step = 0.2)
        //CircleRenderer(Position(), .2)
        //FilledCircleRenderer(Position(), 2.0, innerDivisions = 2)
        SphereRenderer(Position(), 1.0, 0.5)
    //println(lr.divisions)
    lr.forEach { println(it) }
    (object : Audience {

    }).showParticle(Particle.particle(ParticleType.AMBIENT_ENTITY_EFFECT, 5, Color(1f, 0f, 0f, 1f)), Renderer.point(Position()))
}