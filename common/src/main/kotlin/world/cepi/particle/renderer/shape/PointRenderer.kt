package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.renderer.Shape

class PointRenderer : Shape() {
    override fun iterator(): Iterator<Vec> = VectorIterator()

    private class VectorIterator : Iterator<Vec> {
        private var used = false

        override fun hasNext(): Boolean {
            val has = !used
            used = true
            return has
        }

        override fun next(): Vec = Vec(.0, .0, .0)
    }
}