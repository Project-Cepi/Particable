package world.cepi.particle.renderer.transform

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.util.plus

@JvmInline
value class VectorTranslate(val vector: Vec) : Renderer.Transform {
    override fun apply(vector: Vec): Vec = vector + this.vector
}