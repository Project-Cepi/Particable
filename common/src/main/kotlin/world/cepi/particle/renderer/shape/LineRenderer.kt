package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.VecIterable
import world.cepi.particle.util.Vectors
import java.awt.Shape

data class LineRenderer(val vector: Vec, val step: Double = .1) : VecIterable {
    private val vectors = Vectors(Vec.ZERO, vector, step)
    override fun iterator() = vectors.iterator()
}