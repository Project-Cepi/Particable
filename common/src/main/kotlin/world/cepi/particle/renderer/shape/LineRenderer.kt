package world.cepi.particle.renderer.shape

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.util.Vectors

data class LineRenderer(val vector: Vector, val step: Double = .1) : Renderer.Shape() {
    private val vectors = Vectors(Vector(), vector, step)
    override fun iterator() = vectors.iterator()
}