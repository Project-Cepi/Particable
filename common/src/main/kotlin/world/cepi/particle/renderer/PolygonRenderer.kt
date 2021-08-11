package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.util.Vectors
import java.util.*

data class PolygonRenderer(val vectors: Iterable<Vector>, val step: Double) : Renderer {
    private val iterable: Iterable<Vector> = run {
        val i0 = vectors.iterator()
        if (!i0.hasNext()) return@run emptySet<Vector>()
        val p0 = i0.next()
        if (!i0.hasNext()) return@run Collections.singleton(p0)
        val i1 = vectors.iterator()

        val list = LinkedList<Vector>()
        while (i0.hasNext()) {
            Vectors(i1.next(), i0.next(), step).forEach(list::add)
        }
        Vectors(i1.next(), p0, step).forEach(list::add)

        list
    }

    override fun iterator(): Iterator<Vector> = iterable.iterator()
}