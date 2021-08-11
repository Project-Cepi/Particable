package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.util.Vectors

data class LineRenderer(val start: Vector, val end: Vector, val step: Double = .1) : Renderer {
    private val vectors = Vectors(start, end, step)
    override fun iterator() = vectors.iterator()
}