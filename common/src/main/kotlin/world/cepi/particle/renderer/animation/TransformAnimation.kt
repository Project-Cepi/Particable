package world.cepi.particle.renderer.animation

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer

class TransformAnimation(private val callback: (Vec, Int) -> Vec) : Renderer.Animation {
    override fun invoke(vector: Vec, tick: Int): Vec =
        callback(vector, tick)
}