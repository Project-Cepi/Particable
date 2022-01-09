package world.cepi.particle

import world.cepi.particle.data.Color;
import world.cepi.particle.data.OffsetAndSpeed;
import world.cepi.particle.extra.*;
import world.cepi.particle.Particle.Type;
import net.minestom.server.particle.Particle;

object ParticleType {
    @JvmField
    val AMBIENT_ENTITY_EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.AMBIENT_ENTITY_EFFECT)

    @JvmField
    val ANGRY_VILLAGER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ANGRY_VILLAGER)

    @JvmField
    val BLOCK: Type<OffsetAndSpeed, BlockState> = ParticleTypes.Block(Particle.BLOCK)

    @JvmField
    val BUBBLE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.BUBBLE)

    @JvmField
    val CLOUD: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CLOUD)

    @JvmField
    val CRIT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CRIT)

    @JvmField
    val DAMAGE_INDICATOR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DAMAGE_INDICATOR)

    @JvmField
    val DRAGON_BREATH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRAGON_BREATH)

    @JvmField
    val DRIPPING_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_LAVA)

    @JvmField
    val FALLING_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_LAVA)

    @JvmField
    val LANDING_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LANDING_LAVA)

    @JvmField
    val DRIPPING_WATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_WATER)

    @JvmField
    val FALLING_WATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_WATER)

    @JvmField
    val DUST: Type<OffsetAndSpeed, Dust> = ParticleTypes.DUST

    @JvmField
    val DUST_COLOR_TRANSITION: Type<OffsetAndSpeed, DustTransition> = ParticleTypes.DUST_COLOR_TRANSITION

    @JvmField
    val EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.EFFECT)

    @JvmField
    val ELDER_GUARDIAN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ELDER_GUARDIAN)

    @JvmField
    val ENCHANTED_HIT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ENCHANTED_HIT)

    @JvmField
    val ENCHANT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ENCHANT)

    @JvmField
    val END_ROD: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.END_ROD)

    @JvmField
    val ENTITY_EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.ENTITY_EFFECT)

    @JvmField
    val EXPLOSION_EMITTER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.EXPLOSION_EMITTER)

    @JvmField
    val EXPLOSION: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.EXPLOSION)

    @JvmField
    val FALLING_DUST: Type<OffsetAndSpeed, BlockState> = ParticleTypes.Block(Particle.FALLING_DUST)

    @JvmField
    val FIREWORK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FIREWORK)

    @JvmField
    val FISHING: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FISHING)

    @JvmField
    val FLAME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FLAME)

    @JvmField
    val SOUL_FIRE_FLAME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SOUL_FIRE_FLAME)

    @JvmField
    val SOUL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SOUL)

    @JvmField
    val FLASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FLASH)

    @JvmField
    val HAPPY_VILLAGER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.HAPPY_VILLAGER)

    @JvmField
    val COMPOSTER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.COMPOSTER)

    @JvmField
    val HEART: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.HEART)

    @JvmField
    val INSTANT_EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.INSTANT_EFFECT)

    @JvmField
    val ITEM: Type<OffsetAndSpeed, Item> = ParticleTypes.ITEM

    @JvmField
    val VIBRATION: Type<OffsetAndSpeed, Vibration> = ParticleTypes.VIBRATION

    @JvmField
    val ITEM_SLIME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ITEM_SLIME)

    @JvmField
    val ITEM_SNOWBALL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ITEM_SNOWBALL)

    @JvmField
    val LARGE_SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LARGE_SMOKE)

    @JvmField
    val LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LAVA)

    @JvmField
    val MYCELIUM: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.MYCELIUM)

    @JvmField
    val NOTE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.NOTE)

    @JvmField
    val POOF: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.POOF)

    @JvmField
    val PORTAL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.PORTAL)

    @JvmField
    val RAIN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.RAIN)

    @JvmField
    val SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SMOKE)

    @JvmField
    val SNEEZE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SNEEZE)

    @JvmField
    val SPIT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SPIT)

    @JvmField
    val SQUID_INK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SQUID_INK)

    @JvmField
    val SWEEP_ATTACK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SWEEP_ATTACK)

    @JvmField
    val TOTEM_OF_UNDYING: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.TOTEM_OF_UNDYING)

    @JvmField
    val UNDERWATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.UNDERWATER)

    @JvmField
    val SPLASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SPLASH)

    @JvmField
    val WITCH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WITCH)

    @JvmField
    val BUBBLE_POP: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.BUBBLE_POP)

    @JvmField
    val CURRENT_DOWN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CURRENT_DOWN)

    @JvmField
    val BUBBLE_COLUMN_UP: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.BUBBLE_COLUMN_UP)

    @JvmField
    val NAUTILUS: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.NAUTILUS)

    @JvmField
    val DOLPHIN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DOLPHIN)

    @JvmField
    val CAMPFIRE_COSY_SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CAMPFIRE_COSY_SMOKE)

    @JvmField
    val CAMPFIRE_SIGNAL_SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CAMPFIRE_SIGNAL_SMOKE)

    @JvmField
    val DRIPPING_HONEY: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_HONEY)

    @JvmField
    val FALLING_HONEY: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_HONEY)

    @JvmField
    val LANDING_HONEY: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LANDING_HONEY)

    @JvmField
    val FALLING_NECTAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_NECTAR)

    @JvmField
    val FALLING_SPORE_BLOSSOM: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_SPORE_BLOSSOM)

    @JvmField
    val ASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ASH)

    @JvmField
    val CRIMSON_SPORE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CRIMSON_SPORE)

    @JvmField
    val WARPED_SPORE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WARPED_SPORE)

    @JvmField
    val SPORE_BLOSSOM_AIR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SPORE_BLOSSOM_AIR)

    @JvmField
    val DRIPPING_OBSIDIAN_TEAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_OBSIDIAN_TEAR)

    @JvmField
    val FALLING_OBSIDIAN_TEAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_OBSIDIAN_TEAR)

    @JvmField
    val LANDING_OBSIDIAN_TEAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LANDING_OBSIDIAN_TEAR)

    @JvmField
    val REVERSE_PORTAL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.REVERSE_PORTAL)

    @JvmField
    val WHITE_ASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WHITE_ASH)

    @JvmField
    val SMALL_FLAME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SMALL_FLAME)

    @JvmField
    val SNOWFLAKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SNOWFLAKE)

    @JvmField
    val DRIPPING_DRIPSTONE_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_DRIPSTONE_LAVA)

    @JvmField
    val FALLING_DRIPSTONE_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_DRIPSTONE_LAVA)

    @JvmField
    val DRIPPING_DRIPSTONE_WATER: Type<OffsetAndSpeed, NoData> =
        ParticleTypes.Default(Particle.DRIPPING_DRIPSTONE_WATER)

    @JvmField
    val FALLING_DRIPSTONE_WATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_DRIPSTONE_WATER)

    @JvmField
    val GLOW_SQUID_INK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.GLOW_SQUID_INK)

    @JvmField
    val GLOW: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.GLOW)

    @JvmField
    val WAX_ON: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WAX_ON)

    @JvmField
    val WAX_OFF: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WAX_OFF)

    @JvmField
    val ELECTRIC_SPARK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ELECTRIC_SPARK)

    @JvmField
    val SCRAPE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SCRAPE)
}