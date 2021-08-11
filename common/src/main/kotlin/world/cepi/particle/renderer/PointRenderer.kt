package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer

data class PointRenderer(val point: Position) : Renderer {
    override fun iterator(): kotlin.collections.Iterator<Position> = Iterator()

    private inner class Iterator : kotlin.collections.Iterator<Position> {
        private var used = false

        override fun hasNext(): Boolean {
            val has = !used
            used = true
            return has
        }

        override fun next(): Position = point
    }
}