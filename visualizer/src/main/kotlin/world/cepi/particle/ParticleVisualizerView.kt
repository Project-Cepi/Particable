package world.cepi.particle

import javafx.beans.property.SimpleStringProperty
import javafx.scene.Group
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import tornadofx.*
import world.cepi.particle.renderer.Renderer
import javafx.scene.transform.Translate

import javafx.scene.transform.Rotate

import javafx.scene.PerspectiveCamera
import javafx.scene.paint.PhongMaterial

import javafx.scene.shape.DrawMode
import javafx.scene.SubScene

class ParticleVisualizerView : View("Particlable Visualizer") {
    override val root = borderpane {
        left<SelectorView>()
        right<ThreeDimensionalVisualizer>()
    }
}

class SelectorView : View() {
    override val root = vbox {
        combobox<String>(SimpleStringProperty("Circle")) {
            items = Renderer::class.sealedSubclasses.map { it.simpleName!!.dropLast("Renderer".length) }.observable()
        }
    }
}

class ThreeDimensionalVisualizer : View() {
    override val root = vbox {
        val camera: PerspectiveCamera?

        val subScene = SubScene(Group().apply {
            val testBox = Box(1.0, 1.0, 1.0).attachTo(this)
            testBox.material = PhongMaterial(Color(1.0, .0, .0, .5))
            testBox.drawMode = DrawMode.FILL

            // Create and position camera

            // Create and position camera
            camera = PerspectiveCamera(true).attachTo(this)
            camera.transforms.addAll(
                Rotate(-20.0, Rotate.Y_AXIS),
                Rotate(-20.0, Rotate.X_AXIS),
                Translate(.0, .0, -15.0)
            )
        }, 300.0, 300.0).attachTo(this)
        subScene.fill = Color.ALICEBLUE
        subScene.camera = camera

    }
}