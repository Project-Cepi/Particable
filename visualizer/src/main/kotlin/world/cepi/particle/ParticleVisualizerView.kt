package world.cepi.particle

import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Parent
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import tornadofx.*
import world.cepi.particle.renderer.Renderer
import javafx.scene.transform.Translate

import javafx.scene.transform.Rotate

import javafx.scene.PerspectiveCamera
import javafx.scene.paint.PhongMaterial

import javafx.scene.SubScene
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.ScrollEvent
import javafx.scene.transform.Scale
import world.cepi.particle.renderer.CircleRenderer
import world.cepi.particle.renderer.SphereRenderer
import java.util.concurrent.ThreadLocalRandom


class ParticleVisualizerView : View("Particlable Visualizer") {
    override val root = borderpane {
        left<SelectorView>()
        right<ThreeDimensionalVisualizer>()
        bottom<ThreeDimensionalVisualizerSettings>()
    }
}

class SelectorView : View() {
    override val root = vbox {
        combobox<String>(SimpleStringProperty("Circle")) {
            items = Renderer::class.sealedSubclasses.map { it.simpleName!!.dropLast("Renderer".length) }.observable()
        }
    }
}

object WorkspaceSettings {
    var mouseSensitivity = 5.0
}

class ThreeDimensionalVisualizerSettings : View() {
    override val root = vbox {
        label("Visualizer Settings")

        hbox {
            label("Mouse sensitivity")
            val slider = slider(0.1, 10, 5) {
                this.valueProperty().onChange {
                    WorkspaceSettings.mouseSensitivity = it
                }
            }
            button("Reset to default") {
                action {
                    slider.valueProperty().set(5.0)
                }

                slider.valueProperty().onChange {
                    isDisable = it == 5.0
                }
            }
        }
    }
}

class ThreeDimensionalVisualizer : View() {
    override val root = vbox {

        var mouseOldX = 0.0
        var mouseOldY = 0.0

        val camera: PerspectiveCamera?

        val subScene = SubScene(Group().apply {

            Box(.5, .5, .5).attachTo(this).apply {
                material = PhongMaterial(Color(.0, 1.0, .0, .5))
            }

            SphereRenderer(5.0).map {
                Box(.1, .1, .1).attachTo(this).apply {
                    material = PhongMaterial(Color(
                        ThreadLocalRandom.current().nextDouble(0.35, 0.65),
                        ThreadLocalRandom.current().nextDouble(0.35, 0.65),
                        ThreadLocalRandom.current().nextDouble(0.35, 0.65),
                        .4)
                    )

                    translateXProperty().set(it.x)
                    translateYProperty().set(it.y)
                    translateZProperty().set(it.z)
                }
            }

            // Create and position camera
            camera = TransformableCamera().attachTo(this)
            camera.transforms.addAll(
                Translate(.0, .0, -30.0)
            )

            this@vbox.addEventHandler(MouseDragEvent.MOUSE_DRAGGED) { mouseEvent ->
                val mouseDeltaX = mouseEvent.x - mouseOldX
                val mouseDeltaY = mouseEvent.y - mouseOldY
                mouseOldX = mouseEvent.x
                mouseOldY = mouseEvent.y
                if (mouseEvent.isPrimaryButtonDown) {
                    camera.rotateX.angle += mouseDeltaY * WorkspaceSettings.mouseSensitivity
                    camera.rotateY.angle -= mouseDeltaX * WorkspaceSettings.mouseSensitivity
                }
            }

            primaryStage.addEventHandler(ScrollEvent.SCROLL) { event ->
                // Get how much scroll was done in Y axis.
                val delta = -event.deltaY / 300
                // Add it to the Z-axis location.
                camera.scaleXProperty().set((camera.scaleX + delta).coerceAtLeast(.2))
                camera.scaleYProperty().set((camera.scaleY + delta).coerceAtLeast(.2))
                camera.scaleZProperty().set((camera.scaleZ + delta).coerceAtLeast(.2))
            }
        }, 500.0, 500.0).attachTo(this)
        subScene.fill = Color.ALICEBLUE
        subScene.camera = camera

    }
}