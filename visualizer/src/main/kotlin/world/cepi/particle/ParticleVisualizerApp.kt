package world.cepi.particle

import tornadofx.*

fun main() {
    launch<ParticleVisualizerApp>()
}

class ParticleVisualizerApp : App(Workspace::class) {

    override fun onBeforeShow(view: UIComponent) {
        workspace.dock<ParticleVisualizerView>()
    }

}