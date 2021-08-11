package world.cepi.particle

import tornadofx.*

fun main() {
    launch<ParticleVisualizerApp>()
}

class ParticleVisualizerApp : App(ParticleVisualizerView::class)