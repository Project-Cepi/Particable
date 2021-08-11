package world.cepi.particle.renderer

import net.minestom.server.utils.Vector
import world.cepi.particle.Renderer

data class PointsRenderer(val points: Iterable<Vector>) : Renderer, Iterable<Vector> by points