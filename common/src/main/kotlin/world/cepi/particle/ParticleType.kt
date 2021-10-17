package world.cepi.particle

import world.cepi.particle.data.Color;
import world.cepi.particle.data.OffsetAndSpeed;
import world.cepi.particle.extra.*;
import world.cepi.particle.Particle.Type;
import net.minestom.server.particle.Particle;

object ParticleType {
    val AMBIENT_ENTITY_EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.AMBIENT_ENTITY_EFFECT)
    
    val ANGRY_VILLAGER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ANGRY_VILLAGER)
    
    val BARRIER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.BARRIER)
    
    val LIGHT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LIGHT)
    
    val BLOCK: Type<OffsetAndSpeed, BlockState> = ParticleTypes.Block(Particle.BLOCK)
    
    val BUBBLE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.BUBBLE)
    
    val CLOUD: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CLOUD)
    
    val CRIT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CRIT)
    
    val DAMAGE_INDICATOR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DAMAGE_INDICATOR)
    
    val DRAGON_BREATH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRAGON_BREATH)
    
    val DRIPPING_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_LAVA)
    
    val FALLING_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_LAVA)
    
    val LANDING_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LANDING_LAVA)
    
    val DRIPPING_WATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_WATER)
    
    val FALLING_WATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_WATER)
    
    val DUST: Type<OffsetAndSpeed, Dust> = ParticleTypes.DUST
    
    val DUST_COLOR_TRANSITION: Type<OffsetAndSpeed, DustTransition> = ParticleTypes.DUST_COLOR_TRANSITION
    
    val EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.EFFECT)
    
    val ELDER_GUARDIAN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ELDER_GUARDIAN)
    
    val ENCHANTED_HIT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ENCHANTED_HIT)
    
    val ENCHANT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ENCHANT)
    
    val END_ROD: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.END_ROD)
    
    val ENTITY_EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.ENTITY_EFFECT)
    
    val EXPLOSION_EMITTER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.EXPLOSION_EMITTER)
    
    val EXPLOSION: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.EXPLOSION)
    
    val FALLING_DUST: Type<OffsetAndSpeed, BlockState> = ParticleTypes.Block(Particle.FALLING_DUST)
    
    val FIREWORK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FIREWORK)
    
    val FISHING: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FISHING)
    
    val FLAME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FLAME)
    
    val SOUL_FIRE_FLAME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SOUL_FIRE_FLAME)
    
    val SOUL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SOUL)
    
    val FLASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FLASH)
    
    val HAPPY_VILLAGER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.HAPPY_VILLAGER)
    
    val COMPOSTER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.COMPOSTER)
    
    val HEART: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.HEART)
    
    val INSTANT_EFFECT: Type<Color, NoData> = ParticleTypes.Colored(Particle.INSTANT_EFFECT)
    
    val ITEM: Type<OffsetAndSpeed, Item> = ParticleTypes.ITEM
    
    val VIBRATION: Type<OffsetAndSpeed, Vibration> = ParticleTypes.VIBRATION
    
    val ITEM_SLIME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ITEM_SLIME)
    
    val ITEM_SNOWBALL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ITEM_SNOWBALL)

    val LARGE_SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LARGE_SMOKE)

    val LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LAVA)

    val MYCELIUM: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.MYCELIUM)


    val NOTE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.NOTE)


    val POOF: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.POOF)


    val PORTAL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.PORTAL)


    val RAIN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.RAIN)


    val SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SMOKE)


    val SNEEZE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SNEEZE)


    val SPIT: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SPIT)


    val SQUID_INK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SQUID_INK)


    val SWEEP_ATTACK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SWEEP_ATTACK)


    val TOTEM_OF_UNDYING: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.TOTEM_OF_UNDYING)


    val UNDERWATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.UNDERWATER)


    val SPLASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SPLASH)


    val WITCH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WITCH)


    val BUBBLE_POP: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.BUBBLE_POP)


    val CURRENT_DOWN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CURRENT_DOWN)

    val BUBBLE_COLUMN_UP: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.BUBBLE_COLUMN_UP)

    val NAUTILUS: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.NAUTILUS)

    val DOLPHIN: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DOLPHIN)

    val CAMPFIRE_COSY_SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CAMPFIRE_COSY_SMOKE)

    val CAMPFIRE_SIGNAL_SMOKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CAMPFIRE_SIGNAL_SMOKE)

    val DRIPPING_HONEY: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_HONEY)

    val FALLING_HONEY: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_HONEY)

    val LANDING_HONEY: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LANDING_HONEY)

    val FALLING_NECTAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_NECTAR)

    val FALLING_SPORE_BLOSSOM: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_SPORE_BLOSSOM)

    val ASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ASH)

    val CRIMSON_SPORE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.CRIMSON_SPORE)

    val WARPED_SPORE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WARPED_SPORE)

    val SPORE_BLOSSOM_AIR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SPORE_BLOSSOM_AIR)

    val DRIPPING_OBSIDIAN_TEAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_OBSIDIAN_TEAR)

    val FALLING_OBSIDIAN_TEAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_OBSIDIAN_TEAR)

    val LANDING_OBSIDIAN_TEAR: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.LANDING_OBSIDIAN_TEAR)

    val REVERSE_PORTAL: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.REVERSE_PORTAL)

    val WHITE_ASH: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WHITE_ASH)

    val SMALL_FLAME: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SMALL_FLAME)

    val SNOWFLAKE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SNOWFLAKE)

    val DRIPPING_DRIPSTONE_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.DRIPPING_DRIPSTONE_LAVA)

    val FALLING_DRIPSTONE_LAVA: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_DRIPSTONE_LAVA)

    val DRIPPING_DRIPSTONE_WATER: Type<OffsetAndSpeed, NoData> =
        ParticleTypes.Default(Particle.DRIPPING_DRIPSTONE_WATER)

    val FALLING_DRIPSTONE_WATER: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.FALLING_DRIPSTONE_WATER)

    val GLOW_SQUID_INK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.GLOW_SQUID_INK)

    val GLOW: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.GLOW)

    val WAX_ON: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WAX_ON)

    val WAX_OFF: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.WAX_OFF)

    val ELECTRIC_SPARK: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.ELECTRIC_SPARK)

    val SCRAPE: Type<OffsetAndSpeed, NoData> = ParticleTypes.Default(Particle.SCRAPE)
}