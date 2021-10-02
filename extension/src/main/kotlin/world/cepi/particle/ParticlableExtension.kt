package world.cepi.particle

import net.minestom.server.extensions.Extension

class ParticlableExtension : Extension() {

    override fun initialize() {
        logger.info("[Particlable] has been enabled!")
    }

    override fun terminate() {
        logger.info("[Particlable] has been disabled!")
    }

}