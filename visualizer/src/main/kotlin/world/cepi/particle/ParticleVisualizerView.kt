package world.cepi.particle

import tornadofx.*
import world.cepi.particle.renderer.Renderer

class ParticleVisualizerView : View() {
    override val root = borderpane {
        left<SelectorView>()
        right<ThreeDimensionalVisualizer>()
    }
}

class SelectorView : View() {
    override val root = vbox {
        combobox<String> {
            items = Renderer::class.sealedSubclasses.map { it.simpleName!!.dropLast("Renderer".length) }.observable()
        }
    }
}

class ThreeDimensionalVisualizer : View() {
    override val root = vbox {  }
}