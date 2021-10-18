package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer
import world.cepi.particle.renderer.Shape

data class PointsRenderer(val points: Iterable<Vec>) : Shape(), Iterable<Vec> by points