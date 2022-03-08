package world.cepi.particle.data

import net.kyori.examination.ExaminableProperty
import world.cepi.particle.Particle
import java.util.stream.Stream

data class OffsetAndSpeed @JvmOverloads constructor(
    val offX: Float = 0f,
    val offY: Float = 0f,
    val offZ: Float = 0f,
    val speed: Float = 0f
) : Particle.Data {

    override fun examinableProperties(): Stream<out ExaminableProperty> = Stream.of(
        ExaminableProperty.of("offX", offX),
        ExaminableProperty.of("offY", offY),
        ExaminableProperty.of("offZ", offZ),
        ExaminableProperty.of("speed", speed),
    )
}