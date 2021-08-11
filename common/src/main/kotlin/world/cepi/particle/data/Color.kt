package world.cepi.particle.data

import net.kyori.examination.ExaminableProperty
import world.cepi.particle.Particle
import java.util.stream.Stream

data class Color(val red: Float, val green: Float, val blue: Float, val alpha: Float) : Particle.Data {
    override fun examinableProperties(): Stream<out ExaminableProperty> = Stream.of(
        ExaminableProperty.of("red", red),
        ExaminableProperty.of("green", green),
        ExaminableProperty.of("blue", blue),
        ExaminableProperty.of("alpha", alpha),
    )
}