package world.cepi.particle

import net.minestom.server.extensions.Extension

class ParticlableExtension : Extension() {

    override fun initialize(): LoadStatus {
        log.info("[Particlable] has been enabled!")

        return LoadStatus.SUCCESS
    }

    override fun terminate() {
        log.info("[Particlable] has been disabled!")
    }

}