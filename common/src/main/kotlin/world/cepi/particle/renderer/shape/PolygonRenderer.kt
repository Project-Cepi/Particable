package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.PointSequence
import world.cepi.particle.util.Points
import java.util.*

data class PolygonRenderer(val vectors: PointSequence, val step: Double = .1) : PointSequence {
    private val iterable: Iterable<Point> = run {
        val i0 = vectors.iterator()
        if (!i0.hasNext()) return@run emptySet<Vec>()
        val p0 = i0.next()
        if (!i0.hasNext()) return@run Collections.singleton(p0)
        val i1 = vectors.iterator()

        val list = LinkedList<Point>()
        while (i0.hasNext()) {
            Points(i1.next(), i0.next(), step).forEach(list::add)
        }
        Points(i1.next(), p0, step).forEach(list::add)

        list
    }

    override fun iterator(): Iterator<Point> = iterable.iterator()
}