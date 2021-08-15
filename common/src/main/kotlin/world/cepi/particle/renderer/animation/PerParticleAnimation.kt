package world.cepi.particle.renderer.animation

import net.minestom.server.utils.Vector
import world.cepi.particle.renderer.Renderer

class PerParticleAnimation(callback: (Vector, Int, Float) -> Vector)
    : Renderer.Animation, (Vector, Int, Float) -> Vector by callback