package world.cepi.particle.renderer.shape

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer

data class PointsRenderer(val points: Iterable<Vec>) : Renderer.Shape(), Iterable<Vec> by points