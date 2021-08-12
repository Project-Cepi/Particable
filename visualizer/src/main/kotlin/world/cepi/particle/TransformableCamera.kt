package world.cepi.particle

import javafx.scene.PerspectiveCamera
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Translate

internal class TransformableCamera : PerspectiveCamera(true) {
    var t = Translate()
    var p = Translate()
    var ip = Translate()
    var rotateX = Rotate()
    var rotateY = Rotate()
    var rotateZ = Rotate()
    var s: Scale = Scale()

    init {
        rotateX.axis = Rotate.X_AXIS
        rotateY.axis = Rotate.Y_AXIS
        rotateZ.axis = Rotate.Z_AXIS
        transforms.addAll(t, p, rotateX, rotateZ, rotateY, s, ip)
    }
}