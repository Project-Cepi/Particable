package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.renderer.Shape
import world.cepi.particle.util.Vectors

data class LineRenderer(val vector: Vec, val step: Double = .1) : Shape() {
    private val vectors = Vectors(Vec.ZERO, vector, step)
    override fun iterator() = vectors.iterator()
}