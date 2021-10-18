package world.cepi.particle.renderer

import net.minestom.server.coordinate.Vec

abstract class Shape : Iterable<Vec> {
    val count by lazy {
        var i = 0
        for (_0 in iterator()) ++i
        i
    }
}