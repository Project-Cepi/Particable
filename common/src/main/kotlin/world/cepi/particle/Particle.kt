//@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package world.cepi.particle

import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Keyed
import net.kyori.examination.Examinable
import net.kyori.examination.ExaminableProperty
import net.kyori.examination.string.StringExaminer
import java.util.stream.Stream

class Particle<D : Particle.Data, E : Particle.ExtraData>(
    val name: Key,
    val count: Int,
    val particleData: D,
    val extraData: E,
    val longDistance: Boolean = false
) : Examinable {
    companion object {
        fun <D : Data, E : ExtraData> particle(name: Key, count: Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            Particle(name, count, data, extraData, longDistance)

        fun <D : Data, E : ExtraData> particle(type: Type<D, E>, count: Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            particle(type.key(), count, data, extraData, longDistance)

        fun <D : Data, E : ExtraData> particle(type: () -> Type<D, E>, count: Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            Particle(type().key(), count, data, extraData, longDistance)

        fun <D : Data> particle(type: Type<D, NoData>, count: Int, data: D, longDistance: Boolean = false): Particle<D, NoData> =
            particle(type.key(), count, data, NoData, longDistance)

        fun <D : Data> particle(type: () -> Type<D, NoData>, count: Int, data: D, longDistance: Boolean = false): Particle<D, NoData> =
            Particle(type().key(), count, data, NoData, longDistance)

        fun <D : Data, E : ExtraData> particle(type: Type<D, E>, count: () -> Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            Particle(type.key(), count(), data, extraData, longDistance)

        fun <D : Data, E : ExtraData> particle(type: () -> Type<D, E>, count: () -> Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            Particle(type().key(), count(), data, extraData, longDistance)
    }

    override fun examinableProperties(): Stream<out ExaminableProperty> = Stream.of(
        ExaminableProperty.of("name", name),
        ExaminableProperty.of("count", count),
        ExaminableProperty.of("particleData", particleData),
        ExaminableProperty.of("extraData", extraData),
        ExaminableProperty.of("longDistance", longDistance)
    )

    operator fun component1() = name
    operator fun component2() = count
    operator fun component3() = particleData
    operator fun component4() = extraData
    operator fun component5() = longDistance

    override fun toString(): String = examine(StringExaminer.simpleEscaping())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Particle<*, *>

        if (count != other.count) return false
        if (particleData != other.particleData) return false
        if (extraData != other.extraData) return false
        if (longDistance != other.longDistance) return false

        return true
    }

    override fun hashCode(): Int {
        var result = count
        result = 31 * result + particleData.hashCode()
        result = 31 * result + extraData.hashCode()
        result = 31 * result + longDistance.hashCode()
        return result
    }

    interface Type<D : Data, E : ExtraData?> : Keyed

    interface Data : Examinable {
        operator fun component1(): Float
        operator fun component2(): Float
        operator fun component3(): Float
        operator fun component4(): Float
    }

    interface ExtraData : Examinable

}