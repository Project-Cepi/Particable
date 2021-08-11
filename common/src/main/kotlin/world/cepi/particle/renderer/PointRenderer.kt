package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.Renderer

object PointRenderer : Renderer {
    override fun iterator(): Iterator<Vector> = VectorIterator()

    private class VectorIterator : Iterator<Vector> {
        private var used = false

        override fun hasNext(): Boolean {
            val has = !used
            used = true
            return has
        }

        override fun next(): Vector = Vector(.0, .0, .0)
    }
}