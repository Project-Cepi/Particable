package world.cepi.particle.renderer.shape

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.Renderer

object PointRenderer : Renderer.Shape() {
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