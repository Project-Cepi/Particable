package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer
import world.cepi.particle.util.Positions
import java.util.*

data class PolygonRenderer(val positions: Iterable<Position>, val step: Double) : Renderer {
    private val iterable: Iterable<Position> = run {
        val i0 = positions.iterator()
        if (!i0.hasNext()) return@run emptySet<Position>()
        val p0 = i0.next()
        if (!i0.hasNext()) return@run Collections.singleton(p0)
        val i1 = positions.iterator()

        val list = LinkedList<Position>()
        while (i0.hasNext()) {
            Positions(i1.next(), i0.next(), step).forEach(list::add)
        }
        Positions(i1.next(), p0, step).forEach(list::add)

        list
    }

    override fun iterator(): Iterator<Position> = iterable.iterator()
}