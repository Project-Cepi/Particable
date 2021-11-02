package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.VecIterable

data class PointsRenderer(val points: Iterable<Vec>) : VecIterable by points