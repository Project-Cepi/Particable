package world.cepi.particle.renderer

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.animation.PerParticleAnimation
import world.cepi.particle.renderer.animation.TransformAnimation
import world.cepi.particle.util.unaryPlus

@JvmInline
value class Animator internal constructor(@PublishedApi internal val vector: Vec) {
    inline fun transform(transform: Vec.() -> Vec): Vec {
        return transform(vector)
    }
}

internal inline fun buildTransformAnimation(crossinline animation: Animator.(Int) -> Unit): TransformAnimation =
    TransformAnimation { v, i -> Animator(+v).apply { animation(i) }.vector }

internal inline fun buildPerParticleAnimation(crossinline animation: Animator.(Int, Float) -> Unit): PerParticleAnimation =
    PerParticleAnimation { v, i, f -> Animator(+v).apply { animation(i, f) }.vector }

fun Animator.translate(x: Double, y: Double, z: Double) {
    transform {
        add(x, y, z)
    }
}