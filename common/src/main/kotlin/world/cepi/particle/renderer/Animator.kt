package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.animation.PerParticleAnimation
import world.cepi.particle.renderer.animation.TransformAnimation
import world.cepi.particle.util.unaryPlus

@JvmInline
value class Animator internal constructor(@PublishedApi internal val vector: Vector) {
    inline fun transform(transform: Vector.() -> Unit) {
        vector.apply(transform)
    }
}

internal inline fun buildTransformAnimation(crossinline animation: Animator.(Int) -> Unit): TransformAnimation =
    TransformAnimation { v, i -> Animator(+v).apply { animation(i) }.vector }

internal inline fun buildPerParticleAnimation(crossinline animation: Animator.(Int, Float) -> Unit): PerParticleAnimation =
    PerParticleAnimation { v, i, f -> Animator(+v).apply { animation(i, f) }.vector }

fun Animator.translate(x: Double, y: Double, z: Double) {
    transform {
        this.x += x
        this.y += y
        this.z += z
    }
}