package world.cepi.particle.renderer.shape

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.Renderer

data class PointsRenderer(val points: Iterable<Vector>) : Renderer.Shape(), Iterable<Vector> by points