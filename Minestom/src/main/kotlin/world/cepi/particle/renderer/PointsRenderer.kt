package world.cepi.particle.renderer

import net.minestom.server.utils.Position
import world.cepi.particle.Renderer

data class PointsRenderer(val points: Iterable<Position>) : Renderer, Iterable<Position> by points