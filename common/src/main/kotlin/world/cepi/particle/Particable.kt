package world.cepi.particle

import net.minestom.server.extensions.Extension

class Particable : Extension() {

    override fun initialize(): LoadStatus {
        logger().info("[Particlable] has been enabled!")

        return LoadStatus.SUCCESS
    }

    override fun terminate() {
        logger().info("[Particlable] has been disabled!")
    }

}