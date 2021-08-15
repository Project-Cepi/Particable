package world.cepi.particle.renderer.animation

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.Renderer

class TransformAnimation(private val callback: (Vector, Int) -> Vector) : Renderer.Animation {
    override fun invoke(vector: Vector, tick: Int, _0: Float): Vector =
        callback(vector, tick)
}