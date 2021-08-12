package world.cepi.particle

import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.geometry.Point3D
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
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.MouseEvent
import javafx.scene.input.ScrollEvent
import javafx.scene.shape.Circle
import javafx.scene.shape.Sphere
import javafx.scene.transform.Scale


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

        var mouseOldX = 0.0
        var mouseOldY = 0.0

        val camera: PerspectiveCamera?

        val subScene = SubScene(Group().apply {

            Box(.5, .5, .5).attachTo(this).apply {
                material = PhongMaterial(Color(.0, .0, .0, 1.0))
            }

            Box(1.0, 1.0, 1.0).attachTo(this).apply {
                material = PhongMaterial(Color(1.0, .0, .0, .5))
            }

            // Create and position camera
            camera = Cam().attachTo(this)
            camera.transforms.addAll(
                Rotate(-20.0, Rotate.Y_AXIS),
                Rotate(-20.0, Rotate.X_AXIS),
                Translate(.0, .0, -15.0)
            )

            this@vbox.addEventHandler(MouseDragEvent.MOUSE_DRAGGED) { mouseEvent ->
                val mouseDeltaX = mouseEvent.x - mouseOldX
                val mouseDeltaY = mouseEvent.y - mouseOldY
                mouseOldX = mouseEvent.x
                mouseOldY = mouseEvent.y
                if (mouseEvent.isAltDown && mouseEvent.isShiftDown && mouseEvent.isPrimaryButtonDown) {
                    camera.rz.angle = camera.rz.angle - mouseDeltaX
                } else if (mouseEvent.isAltDown && mouseEvent.isPrimaryButtonDown) {
                    camera.ry.angle = camera.ry.angle - mouseDeltaX
                    camera.rx.angle = camera.rx.angle + mouseDeltaY
                } else if (mouseEvent.isAltDown && mouseEvent.isSecondaryButtonDown) {
                    val scale: Double = camera.s.x
                    val newScale: Double = scale + mouseDeltaX * 0.01
                    camera.scaleX = newScale
                    camera.scaleY = newScale
                    camera.scaleZ = newScale
                } else if (mouseEvent.isAltDown && mouseEvent.isMiddleButtonDown) {
                    camera.t.x = camera.t.x + mouseDeltaX
                    camera.t.y = camera.t.y + mouseDeltaY
                }
            }

            primaryStage.addEventHandler(ScrollEvent.SCROLL) { event ->
                // Get how much scroll was done in Y axis.
                val delta = event.deltaY
                // Add it to the Z-axis location.
                camera.translateZProperty().set(camera.translateZ + (delta / 100))
            }
        }, 300.0, 300.0).attachTo(this)
        subScene.fill = Color.ALICEBLUE
        subScene.camera = camera

    }
}

internal class Cam : PerspectiveCamera(true) {
    var t = Translate()
    var p = Translate()
    var ip = Translate()
    var rx = Rotate()
    var ry = Rotate()
    var rz = Rotate()
    var s: Scale = Scale()

    init {
        rx.axis = Rotate.X_AXIS
        ry.axis = Rotate.Y_AXIS
        rz.axis = Rotate.Z_AXIS
        transforms.addAll(t, p, rx, rz, ry, s, ip)
    }
}