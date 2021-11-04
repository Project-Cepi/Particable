package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.VecSequence
import world.cepi.particle.util.Vectors
import java.awt.Shape
import java.util.*

data class PolygonRenderer(val vectors: VecSequence, val step: Double = .1) : VecSequence {
    private val iterable: Iterable<Vec> = run {
        val i0 = vectors.iterator()
        if (!i0.hasNext()) return@run emptySet<Vec>()
        val p0 = i0.next()
        if (!i0.hasNext()) return@run Collections.singleton(p0)
        val i1 = vectors.iterator()

        val list = LinkedList<Vec>()
        while (i0.hasNext()) {
            Vectors(i1.next(), i0.next(), step).forEach(list::add)
        }
        Vectors(i1.next(), p0, step).forEach(list::add)

        list
    }

    override fun iterator(): Iterator<Vec> = iterable.iterator()
}