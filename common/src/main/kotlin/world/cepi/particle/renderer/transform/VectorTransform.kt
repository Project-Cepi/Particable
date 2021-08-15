package world.cepi.particle.renderer.transform

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.util.plus

@JvmInline
value class VectorTransform(val vector: Vector) : Renderer.Transform {
    override fun apply(vector: Vector): Vector = vector + this.vector
}