package flavor.pie.sunkcost

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.Particle
import org.spongepowered.api.effect.particle.ParticleType
import org.spongepowered.api.effect.particle.ParticleTypes

private val particleMap: BiMap<Particle, ParticleType> = HashBiMap.create(
    mapOf(
        Particle.BARRIER to ParticleTypes.BARRIER,
        Particle.BLOCK_CRACK to ParticleTypes.BLOCK_CRACK,
        Particle.BLOCK_DUST to ParticleTypes.BLOCK_DUST,
        Particle.CLOUD to ParticleTypes.CLOUD,
        Particle.CRIT to ParticleTypes.CRITICAL_HIT,
        Particle.CRIT_MAGIC to ParticleTypes.MAGIC_CRITICAL_HIT,
        Particle.DAMAGE_INDICATOR to ParticleTypes.DAMAGE_INDICATOR,
        Particle.DRAGON_BREATH to ParticleTypes.DRAGON_BREATH,
        Particle.DRIP_LAVA to ParticleTypes.DRIP_LAVA,
        Particle.DRIP_WATER to ParticleTypes.DRIP_WATER,
        Particle.ENCHANTMENT_TABLE to ParticleTypes.ENCHANTING_GLYPHS,
        Particle.END_ROD to ParticleTypes.END_ROD,
        Particle.EXPLOSION_HUGE to ParticleTypes.HUGE_EXPLOSION,
        Particle.EXPLOSION_LARGE to ParticleTypes.LARGE_EXPLOSION,
        Particle.EXPLOSION_NORMAL to ParticleTypes.EXPLOSION,
        Particle.FALLING_DUST to ParticleTypes.FALLING_DUST,
        Particle.FIREWORKS_SPARK to ParticleTypes.FIREWORKS_SPARK,
        Particle.FLAME to ParticleTypes.FLAME,
        Particle.FOOTSTEP to ParticleTypes.FOOTSTEP,
        Particle.HEART to ParticleTypes.HEART,
        Particle.ITEM_CRACK to ParticleTypes.ITEM_CRACK,
        Particle.LAVA to ParticleTypes.LAVA,
        Particle.MOB_APPEARANCE to ParticleTypes.MOBSPAWNER_FLAMES,
        Particle.NOTE to ParticleTypes.NOTE,
        Particle.PORTAL to ParticleTypes.PORTAL,
        Particle.REDSTONE to ParticleTypes.REDSTONE_DUST,
        Particle.SLIME to ParticleTypes.SLIME,
        Particle.SMOKE_LARGE to ParticleTypes.LARGE_SMOKE,
        Particle.SMOKE_NORMAL to ParticleTypes.SMOKE,
        Particle.SNOWBALL to ParticleTypes.SNOWBALL,
        Particle.SNOW_SHOVEL to ParticleTypes.SNOW_SHOVEL,
        Particle.SPELL to ParticleTypes.SPELL,
        Particle.SPELL_INSTANT to ParticleTypes.SPLASH_POTION,
        Particle.SPELL_MOB to ParticleTypes.MOB_SPELL,
        Particle.SPELL_MOB_AMBIENT to ParticleTypes.AMBIENT_MOB_SPELL,
        Particle.SPELL_WITCH to ParticleTypes.WITCH_SPELL,
        Particle.SUSPENDED to ParticleTypes.SUSPENDED,
        Particle.SUSPENDED_DEPTH to ParticleTypes.SUSPENDED_DEPTH,
        Particle.SWEEP_ATTACK to ParticleTypes.SWEEP_ATTACK,
        Particle.TOWN_AURA to ParticleTypes.TOWN_AURA,
        Particle.VILLAGER_ANGRY to ParticleTypes.ANGRY_VILLAGER,
        Particle.VILLAGER_HAPPY to ParticleTypes.HAPPY_VILLAGER,
        Particle.WATER_BUBBLE to ParticleTypes.WATER_BUBBLE,
        Particle.WATER_DROP to ParticleTypes.WATER_DROP,
        Particle.WATER_SPLASH to ParticleTypes.WATER_SPLASH,
        Particle.WATER_WAKE to ParticleTypes.WATER_WAKE
    )
)

fun Particle.particleType(): ParticleType? = particleMap[this]

fun ParticleType.particle(): Particle? = particleMap.inverse()[this]
