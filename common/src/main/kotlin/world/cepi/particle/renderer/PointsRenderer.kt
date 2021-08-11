package world.cepi.particle.renderer

import net.minestom.server.utils.Vector

data class PointsRenderer(val points: Iterable<Vector>) : Renderer, Iterable<Vector> by points