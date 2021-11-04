package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.VecSequence
import world.cepi.particle.util.Vectors
import java.awt.Shape

data class LineRenderer(val vector: Vec, val step: Double = .1) : VecSequence {
    private val vectors = Vectors(Vec.ZERO, vector, step)
    override fun iterator() = vectors.iterator()
}