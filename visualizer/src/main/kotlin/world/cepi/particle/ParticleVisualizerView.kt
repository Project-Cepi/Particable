package world.cepi.particle

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleStringProperty
import javafx.scene.*
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import tornadofx.*
import world.cepi.particle.renderer.Renderer
import javafx.scene.transform.Translate

import javafx.scene.paint.PhongMaterial

import javafx.scene.input.MouseDragEvent
import javafx.scene.input.ScrollEvent
import world.cepi.particle.renderer.shape.SphereRenderer
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
    val mouseSensitivity = 5.0.toProperty()
    val scrollSensitivity = 300.0.toProperty()
    val axisVisible = true.toProperty()
    val centerVisible = true.toProperty()
}

class ThreeDimensionalVisualizerSettings : View() {
    override val root = vbox {
        label("Visualizer Settings")

        hbox {
            label("Mouse sensitivity")

            slider(0.1..10.0, 5.0) {
                Bindings.bindBidirectional(this.valueProperty(), WorkspaceSettings.mouseSensitivity)
            }

            button("Reset to default") {

                isDisable = true

                action {
                    WorkspaceSettings.mouseSensitivity.set(5.0)
                    isDisable = true
                }

                WorkspaceSettings.mouseSensitivity.onChange {
                    isDisable = it == 5.0
                }
            }
        }

        hbox {
            label("Scroll sensitivity")

            slider(100, 500, 300) {
                Bindings.bindBidirectional(this.valueProperty(), WorkspaceSettings.scrollSensitivity)
            }

            button("Reset to default") {

                isDisable = true

                action {
                    WorkspaceSettings.scrollSensitivity.set(300.0)
                    isDisable = true
                }

                WorkspaceSettings.scrollSensitivity.onChange {
                    isDisable = it == 300.0
                }
            }
        }

        checkbox("Show axis", WorkspaceSettings.axisVisible)

        checkbox("Show center", WorkspaceSettings.centerVisible)
    }
}

class ThreeDimensionalVisualizer : View() {
    override val root = vbox {

        var mouseOldX = 0.0
        var mouseOldY = 0.0

        val camera: PerspectiveCamera?

        val subScene = SubScene(Group().apply {

            Box(500.0, .1, .1).attachTo(this).apply {
                material = PhongMaterial(Color(1.0, .0, .0, .7))

                visibleWhen(WorkspaceSettings.axisVisible)
            }

            Box(.1, 500.0, .1).attachTo(this).apply {
                material = PhongMaterial(Color(.0, 1.0, .0, .7))

                visibleWhen(WorkspaceSettings.axisVisible)
            }

            Box(.1, .1, 500.0).attachTo(this).apply {
                material = PhongMaterial(Color(.0, .0, 1.0, .7))

                visibleWhen(WorkspaceSettings.axisVisible)
            }

            Box(.5, .5, .5).attachTo(this).apply {
                material = PhongMaterial(Color(.0, 1.0, .0, .5))

                visibleWhen(WorkspaceSettings.centerVisible)
            }

            SphereRenderer(5.0).map {
                Box(.1, .1, .1).attachTo(this).apply {
                    material = PhongMaterial(Color(
                        ThreadLocalRandom.current().nextDouble(0.35, 0.65),
                        ThreadLocalRandom.current().nextDouble(0.35, 0.65),
                        ThreadLocalRandom.current().nextDouble(0.35, 0.65),
                        .4)
                    )

                    translateXProperty().set(it.x())
                    translateYProperty().set(it.y())
                    translateZProperty().set(it.z())
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
                    camera.rotateX.angle += mouseDeltaY * WorkspaceSettings.mouseSensitivity.get()
                    camera.rotateY.angle -= mouseDeltaX * WorkspaceSettings.mouseSensitivity.get()
                }
            }

            primaryStage.addEventHandler(ScrollEvent.SCROLL) { event ->
                // Get how much scroll was done in Y axis.
                val delta = -event.deltaY / WorkspaceSettings.scrollSensitivity.get()
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