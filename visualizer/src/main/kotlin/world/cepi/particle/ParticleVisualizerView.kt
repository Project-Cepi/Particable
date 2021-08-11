package world.cepi.particle

import javafx.scene.Parent
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
        listview<String> {
            items.addAll(Renderer::class.sealedSubclasses.map { it.simpleName!!.dropLast("Renderer".length) })

            useMaxHeight = true
        }
    }
}

class ThreeDimensionalVisualizer : View() {
    override val root = vbox {  }
}