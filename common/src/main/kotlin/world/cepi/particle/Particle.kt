@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package world.cepi.particle

import world.cepi.particle.impl.ParticleImpl
import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Keyed
import net.kyori.examination.Examinable
import net.minestom.server.utils.Vector
import org.jetbrains.annotations.ApiStatus

@ApiStatus.NonExtendable
interface Particle<D : Particle.Data, E : Particle.ExtraData> : Examinable {
    companion object {
        fun <D : Data, E : ExtraData> particle(name: Key, count: Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            object : ParticleImpl<D, E>(longDistance, data, extraData) {
                override val name = name
                override val count = count
            }

        fun <D : Data, E : ExtraData> particle(type: Type<D, E>, count: Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            particle(type.key(), count, data, extraData, longDistance)

        fun <D : Data, E : ExtraData> particle(type: () -> Type<D, E>, count: Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            object : ParticleImpl<D, E>(longDistance, data, extraData) {
                override val name get() = type().key()
                override val count = count
            }

        fun <D : Data> particle(type: Type<D, Nothing>, count: Int, data: D, longDistance: Boolean = false): Particle<D, Nothing> =
            particle(type.key(), count, data, Nothing, longDistance)

        fun <D : Data> particle(type: () -> Type<D, Nothing>, count: Int, data: D, longDistance: Boolean = false): Particle<D, Nothing> =
            object : ParticleImpl<D, Nothing>(longDistance, data, Nothing) {
                override val name get() = type().key()
                override val count = count
            }

        fun <D : Data, E : ExtraData> particle(type: Type<D, E>, count: () -> Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            object : ParticleImpl<D, E>(longDistance, data, extraData) {
                override val name = type.key()
                override val count get() = count()
            }

        fun <D : Data, E : ExtraData> particle(type: () -> Type<D, E>, count: () -> Int, data: D, extraData: E, longDistance: Boolean = false): Particle<D, E> =
            object : ParticleImpl<D, E>(longDistance, data, extraData) {
                override val name get() = type().key()
                override val count get() = count()
            }
    }

    val name: Key

    val count: Int

    val particleData: D

    val extraData: E

    val longDistance: Boolean

    interface Type<D : Data, E : ExtraData?> : Keyed

    interface Data : Examinable {
        operator fun component1(): Float
        operator fun component2(): Float
        operator fun component3(): Float
        operator fun component4(): Float
    }

    interface ExtraData : Examinable

    interface Renderer : Iterable<Vector>
}