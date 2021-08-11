package world.cepi.particle.data

import net.kyori.examination.ExaminableProperty
import world.cepi.particle.Particle
import java.util.stream.Stream

data class OffsetAndSpeed(val offX: Float, val offY: Float, val offZ: Float, val speed: Float) : Particle.Data {
    override fun examinableProperties(): Stream<out ExaminableProperty> = Stream.of(
        ExaminableProperty.of("offX", offX),
        ExaminableProperty.of("offY", offY),
        ExaminableProperty.of("offZ", offZ),
        ExaminableProperty.of("speed", speed),
    )
}