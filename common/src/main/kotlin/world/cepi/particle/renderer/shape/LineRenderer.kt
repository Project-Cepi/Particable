package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.PointSequence
import world.cepi.particle.util.Points

data class LineRenderer(val point: Point, val step: Double = .1) : PointSequence {
    private val points = Points(Vec.ZERO, point, step)
    override fun iterator() = points.iterator()
}