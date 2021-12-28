import world.cepi.particle.Particle;
import world.cepi.particle.ParticleType;
import world.cepi.particle.data.OffsetAndSpeed;
import world.cepi.particle.extra.Dust;

public class JavaTest {

    public static void main() {
        Particle.particle(
                ParticleType.DUST.key(),
                1,
                new OffsetAndSpeed(),
                new Dust(1f, 1f, 1f, 1f)
        );
    }

}
