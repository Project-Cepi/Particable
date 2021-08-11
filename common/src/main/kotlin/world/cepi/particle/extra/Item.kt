@file:Suppress("MemberVisibilityCanBePrivate")

package world.cepi.particle.extra

import net.minestom.server.item.ItemStack
import net.minestom.server.utils.binary.BinaryWriter
import world.cepi.particle.ParticleTypes

@JvmInline
value class Item(val itemStack: ItemStack) : ParticleTypes.BinaryData {
    override fun accept(t: BinaryWriter) {
        t.writeItemStack(itemStack)
    }
}