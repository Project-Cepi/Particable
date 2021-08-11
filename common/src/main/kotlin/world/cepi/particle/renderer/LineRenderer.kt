package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer
import world.cepi.particle.util.Positions

data class LineRenderer(val start: Position, val end: Position, val step: Double) : Renderer {
    private val positions = Positions(start, end, step)
    override fun iterator() = positions.iterator()
}