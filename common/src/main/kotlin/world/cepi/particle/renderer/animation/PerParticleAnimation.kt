package world.cepi.particle.renderer.animation

import net.minestom.server.coordinate.Vec
import world.cepi.particle.renderer.Renderer

class PerParticleAnimation(callback: (Vec, Int, Float) -> Vec)
    : Renderer.Animation, (Vec, Int, Float) -> Vec by callback