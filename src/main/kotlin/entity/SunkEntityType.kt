package flavor.pie.sunkcost.entity

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.entity.AreaEffectCloud
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.Arrow
import org.bukkit.entity.Bat
import org.bukkit.entity.Blaze
import org.bukkit.entity.Boat
import org.bukkit.entity.CaveSpider
import org.bukkit.entity.Chicken
import org.bukkit.entity.ComplexEntityPart
import org.bukkit.entity.Cow
import org.bukkit.entity.Creeper
import org.bukkit.entity.Donkey
import org.bukkit.entity.DragonFireball
import org.bukkit.entity.Egg
import org.bukkit.entity.ElderGuardian
import org.bukkit.entity.EnderCrystal
import org.bukkit.entity.EnderDragon
import org.bukkit.entity.EnderPearl
import org.bukkit.entity.EnderSignal
import org.bukkit.entity.Enderman
import org.bukkit.entity.Endermite
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Evoker
import org.bukkit.entity.EvokerFangs
import org.bukkit.entity.ExperienceOrb
import org.bukkit.entity.FallingBlock
import org.bukkit.entity.Fireball
import org.bukkit.entity.Firework
import org.bukkit.entity.FishHook
import org.bukkit.entity.Ghast
import org.bukkit.entity.Giant
import org.bukkit.entity.Guardian
import org.bukkit.entity.Horse
import org.bukkit.entity.Husk
import org.bukkit.entity.Illusioner
import org.bukkit.entity.IronGolem
import org.bukkit.entity.Item
import org.bukkit.entity.ItemFrame
import org.bukkit.entity.LeashHitch
import org.bukkit.entity.LightningStrike
import org.bukkit.entity.LingeringPotion
import org.bukkit.entity.Llama
import org.bukkit.entity.LlamaSpit
import org.bukkit.entity.MagmaCube
import org.bukkit.entity.Minecart
import org.bukkit.entity.Mule
import org.bukkit.entity.MushroomCow
import org.bukkit.entity.Ocelot
import org.bukkit.entity.Painting
import org.bukkit.entity.Parrot
import org.bukkit.entity.Pig
import org.bukkit.entity.PigZombie
import org.bukkit.entity.Player
import org.bukkit.entity.PolarBear
import org.bukkit.entity.Rabbit
import org.bukkit.entity.Sheep
import org.bukkit.entity.Shulker
import org.bukkit.entity.ShulkerBullet
import org.bukkit.entity.Silverfish
import org.bukkit.entity.Skeleton
import org.bukkit.entity.SkeletonHorse
import org.bukkit.entity.Slime
import org.bukkit.entity.SmallFireball
import org.bukkit.entity.Snowball
import org.bukkit.entity.Snowman
import org.bukkit.entity.SpectralArrow
import org.bukkit.entity.Spider
import org.bukkit.entity.SplashPotion
import org.bukkit.entity.Squid
import org.bukkit.entity.Stray
import org.bukkit.entity.TNTPrimed
import org.bukkit.entity.ThrownExpBottle
import org.bukkit.entity.TippedArrow
import org.bukkit.entity.Vex
import org.bukkit.entity.Villager
import org.bukkit.entity.Vindicator
import org.bukkit.entity.Weather
import org.bukkit.entity.Witch
import org.bukkit.entity.Wither
import org.bukkit.entity.WitherSkeleton
import org.bukkit.entity.WitherSkull
import org.bukkit.entity.Wolf
import org.bukkit.entity.Zombie
import org.bukkit.entity.ZombieHorse
import org.bukkit.entity.ZombieVillager
import org.bukkit.entity.minecart.CommandMinecart
import org.bukkit.entity.minecart.ExplosiveMinecart
import org.bukkit.entity.minecart.HopperMinecart
import org.bukkit.entity.minecart.PoweredMinecart
import org.bukkit.entity.minecart.SpawnerMinecart
import org.bukkit.entity.minecart.StorageMinecart
import org.spongepowered.api.entity.EntityTypes
import org.spongepowered.api.entity.EntityType as SEntityType

private val typeToClassMap: BiMap<EntityType, Class<out Entity>> = HashBiMap.create(EntityType.values().associate {
    it to when (it) {
        EntityType.DROPPED_ITEM -> Item::class.java
        EntityType.EXPERIENCE_ORB -> ExperienceOrb::class.java
        EntityType.AREA_EFFECT_CLOUD -> AreaEffectCloud::class.java
        EntityType.ELDER_GUARDIAN -> ElderGuardian::class.java
        EntityType.WITHER_SKELETON -> WitherSkeleton::class.java
        EntityType.STRAY -> Stray::class.java
        EntityType.EGG -> Egg::class.java
        EntityType.LEASH_HITCH -> LeashHitch::class.java
        EntityType.PAINTING -> Painting::class.java
        EntityType.ARROW -> Arrow::class.java
        EntityType.SNOWBALL -> Snowball::class.java
        EntityType.FIREBALL -> Fireball::class.java
        EntityType.SMALL_FIREBALL -> SmallFireball::class.java
        EntityType.ENDER_PEARL -> EnderPearl::class.java
        EntityType.ENDER_SIGNAL -> EnderSignal::class.java
        EntityType.SPLASH_POTION -> SplashPotion::class.java
        EntityType.THROWN_EXP_BOTTLE -> ThrownExpBottle::class.java
        EntityType.ITEM_FRAME -> ItemFrame::class.java
        EntityType.WITHER_SKULL -> WitherSkull::class.java
        EntityType.PRIMED_TNT -> TNTPrimed::class.java
        EntityType.FALLING_BLOCK -> FallingBlock::class.java
        EntityType.FIREWORK -> Firework::class.java
        EntityType.HUSK -> Husk::class.java
        EntityType.SPECTRAL_ARROW -> SpectralArrow::class.java
        EntityType.SHULKER_BULLET -> ShulkerBullet::class.java
        EntityType.DRAGON_FIREBALL -> DragonFireball::class.java
        EntityType.ZOMBIE_VILLAGER -> ZombieVillager::class.java
        EntityType.SKELETON_HORSE -> SkeletonHorse::class.java
        EntityType.ZOMBIE_HORSE -> ZombieHorse::class.java
        EntityType.ARMOR_STAND -> ArmorStand::class.java
        EntityType.DONKEY -> Donkey::class.java
        EntityType.MULE -> Mule::class.java
        EntityType.EVOKER_FANGS -> EvokerFangs::class.java
        EntityType.EVOKER -> Evoker::class.java
        EntityType.VEX -> Vex::class.java
        EntityType.VINDICATOR -> Vindicator::class.java
        EntityType.ILLUSIONER -> Illusioner::class.java
        EntityType.MINECART_COMMAND -> CommandMinecart::class.java
        EntityType.BOAT -> Boat::class.java
        EntityType.MINECART -> Minecart::class.java
        EntityType.MINECART_CHEST -> StorageMinecart::class.java
        EntityType.MINECART_FURNACE -> PoweredMinecart::class.java
        EntityType.MINECART_TNT -> ExplosiveMinecart::class.java
        EntityType.MINECART_HOPPER -> HopperMinecart::class.java
        EntityType.MINECART_MOB_SPAWNER -> SpawnerMinecart::class.java
        EntityType.CREEPER -> Creeper::class.java
        EntityType.SKELETON -> Skeleton::class.java
        EntityType.SPIDER -> Spider::class.java
        EntityType.GIANT -> Giant::class.java
        EntityType.ZOMBIE -> Zombie::class.java
        EntityType.SLIME -> Slime::class.java
        EntityType.GHAST -> Ghast::class.java
        EntityType.PIG_ZOMBIE -> PigZombie::class.java
        EntityType.ENDERMAN -> Enderman::class.java
        EntityType.CAVE_SPIDER -> CaveSpider::class.java
        EntityType.SILVERFISH -> Silverfish::class.java
        EntityType.BLAZE -> Blaze::class.java
        EntityType.MAGMA_CUBE -> MagmaCube::class.java
        EntityType.ENDER_DRAGON -> EnderDragon::class.java
        EntityType.WITHER -> Wither::class.java
        EntityType.BAT -> Bat::class.java
        EntityType.WITCH -> Witch::class.java
        EntityType.ENDERMITE -> Endermite::class.java
        EntityType.GUARDIAN -> Guardian::class.java
        EntityType.SHULKER -> Shulker::class.java
        EntityType.PIG -> Pig::class.java
        EntityType.SHEEP -> Sheep::class.java
        EntityType.COW -> Cow::class.java
        EntityType.CHICKEN -> Chicken::class.java
        EntityType.SQUID -> Squid::class.java
        EntityType.WOLF -> Wolf::class.java
        EntityType.MUSHROOM_COW -> MushroomCow::class.java
        EntityType.SNOWMAN -> Snowman::class.java
        EntityType.OCELOT -> Ocelot::class.java
        EntityType.IRON_GOLEM -> IronGolem::class.java
        EntityType.HORSE -> Horse::class.java
        EntityType.RABBIT -> Rabbit::class.java
        EntityType.POLAR_BEAR -> PolarBear::class.java
        EntityType.LLAMA -> Llama::class.java
        EntityType.LLAMA_SPIT -> LlamaSpit::class.java
        EntityType.PARROT -> Parrot::class.java
        EntityType.VILLAGER -> Villager::class.java
        EntityType.ENDER_CRYSTAL -> EnderCrystal::class.java
        EntityType.LINGERING_POTION -> LingeringPotion::class.java
        EntityType.FISHING_HOOK -> FishHook::class.java
        EntityType.LIGHTNING -> LightningStrike::class.java
        EntityType.WEATHER -> Weather::class.java
        EntityType.PLAYER -> Player::class.java
        EntityType.COMPLEX_PART -> ComplexEntityPart::class.java
        EntityType.TIPPED_ARROW -> TippedArrow::class.java
        EntityType.UNKNOWN -> Entity::class.java
    }
})

fun Class<out Entity>.entityType(): EntityType = typeToClassMap.inverse()[this] ?: EntityType.UNKNOWN

private val entityTypeMap: BiMap<EntityType, SEntityType> = HashBiMap.create(EntityType.values().associate {
    it to when (it) {
        EntityType.DROPPED_ITEM -> EntityTypes.ITEM
        EntityType.EXPERIENCE_ORB -> EntityTypes.EXPERIENCE_ORB
        EntityType.AREA_EFFECT_CLOUD -> EntityTypes.AREA_EFFECT_CLOUD
        EntityType.ELDER_GUARDIAN -> EntityTypes.ELDER_GUARDIAN
        EntityType.WITHER_SKELETON -> EntityTypes.WITHER_SKELETON
        EntityType.STRAY -> EntityTypes.STRAY
        EntityType.EGG -> EntityTypes.EGG
        EntityType.LEASH_HITCH -> EntityTypes.LEASH_HITCH
        EntityType.PAINTING -> EntityTypes.PAINTING
        EntityType.ARROW -> EntityTypes.TIPPED_ARROW
        EntityType.SNOWBALL -> EntityTypes.SNOWBALL
        EntityType.FIREBALL -> EntityTypes.FIREBALL
        EntityType.SMALL_FIREBALL -> EntityTypes.SMALL_FIREBALL
        EntityType.ENDER_PEARL -> EntityTypes.ENDER_PEARL
        EntityType.ENDER_SIGNAL -> EntityTypes.EYE_OF_ENDER
        EntityType.SPLASH_POTION -> EntityTypes.SPLASH_POTION
        EntityType.THROWN_EXP_BOTTLE -> EntityTypes.THROWN_EXP_BOTTLE
        EntityType.ITEM_FRAME -> EntityTypes.ITEM_FRAME
        EntityType.WITHER_SKULL -> EntityTypes.WITHER_SKULL
        EntityType.PRIMED_TNT -> EntityTypes.PRIMED_TNT
        EntityType.FALLING_BLOCK -> EntityTypes.FALLING_BLOCK
        EntityType.FIREWORK -> EntityTypes.FIREWORK
        EntityType.HUSK -> EntityTypes.HUSK
        EntityType.SPECTRAL_ARROW -> EntityTypes.SPECTRAL_ARROW
        EntityType.SHULKER_BULLET -> EntityTypes.SHULKER_BULLET
        EntityType.DRAGON_FIREBALL -> EntityTypes.DRAGON_FIREBALL
        EntityType.ZOMBIE_VILLAGER -> EntityTypes.ZOMBIE_VILLAGER
        EntityType.SKELETON_HORSE -> EntityTypes.SKELETON_HORSE
        EntityType.ZOMBIE_HORSE -> EntityTypes.ZOMBIE_HORSE
        EntityType.ARMOR_STAND -> EntityTypes.ARMOR_STAND
        EntityType.DONKEY -> EntityTypes.DONKEY
        EntityType.MULE -> EntityTypes.MULE
        EntityType.EVOKER_FANGS -> EntityTypes.EVOCATION_FANGS
        EntityType.EVOKER -> EntityTypes.EVOCATION_ILLAGER
        EntityType.VEX -> EntityTypes.VEX
        EntityType.VINDICATOR -> EntityTypes.VINDICATION_ILLAGER
        EntityType.ILLUSIONER -> EntityTypes.ILLUSION_ILLAGER
        EntityType.MINECART_COMMAND -> EntityTypes.COMMANDBLOCK_MINECART
        EntityType.BOAT -> EntityTypes.BOAT
        EntityType.MINECART -> EntityTypes.RIDEABLE_MINECART
        EntityType.MINECART_CHEST -> EntityTypes.CHESTED_MINECART
        EntityType.MINECART_FURNACE -> EntityTypes.FURNACE_MINECART
        EntityType.MINECART_TNT -> EntityTypes.TNT_MINECART
        EntityType.MINECART_HOPPER -> EntityTypes.HOPPER_MINECART
        EntityType.MINECART_MOB_SPAWNER -> EntityTypes.MOB_SPAWNER_MINECART
        EntityType.CREEPER -> EntityTypes.CREEPER
        EntityType.SKELETON -> EntityTypes.SKELETON
        EntityType.SPIDER -> EntityTypes.SPIDER
        EntityType.GIANT -> EntityTypes.GIANT
        EntityType.ZOMBIE -> EntityTypes.ZOMBIE
        EntityType.SLIME -> EntityTypes.SLIME
        EntityType.GHAST -> EntityTypes.GHAST
        EntityType.PIG_ZOMBIE -> EntityTypes.PIG_ZOMBIE
        EntityType.ENDERMAN -> EntityTypes.ENDERMAN
        EntityType.CAVE_SPIDER -> EntityTypes.CAVE_SPIDER
        EntityType.SILVERFISH -> EntityTypes.SILVERFISH
        EntityType.BLAZE -> EntityTypes.BLAZE
        EntityType.MAGMA_CUBE -> EntityTypes.MAGMA_CUBE
        EntityType.ENDER_DRAGON -> EntityTypes.ENDER_DRAGON
        EntityType.WITHER -> EntityTypes.WITHER
        EntityType.BAT -> EntityTypes.BAT
        EntityType.WITCH -> EntityTypes.WITCH
        EntityType.ENDERMITE -> EntityTypes.ENDERMITE
        EntityType.GUARDIAN -> EntityTypes.GUARDIAN
        EntityType.SHULKER -> EntityTypes.SHULKER
        EntityType.PIG -> EntityTypes.PIG
        EntityType.SHEEP -> EntityTypes.SHEEP
        EntityType.COW -> EntityTypes.COW
        EntityType.CHICKEN -> EntityTypes.CHICKEN
        EntityType.SQUID -> EntityTypes.SQUID
        EntityType.WOLF -> EntityTypes.WOLF
        EntityType.MUSHROOM_COW -> EntityTypes.MUSHROOM_COW
        EntityType.SNOWMAN -> EntityTypes.SNOWMAN
        EntityType.OCELOT -> EntityTypes.OCELOT
        EntityType.IRON_GOLEM -> EntityTypes.IRON_GOLEM
        EntityType.HORSE -> EntityTypes.HORSE
        EntityType.RABBIT -> EntityTypes.RABBIT
        EntityType.POLAR_BEAR -> EntityTypes.POLAR_BEAR
        EntityType.LLAMA -> EntityTypes.LLAMA
        EntityType.LLAMA_SPIT -> EntityTypes.LLAMA_SPIT
        EntityType.PARROT -> EntityTypes.PARROT
        EntityType.VILLAGER -> EntityTypes.VILLAGER
        EntityType.ENDER_CRYSTAL -> EntityTypes.ENDER_CRYSTAL
        EntityType.LINGERING_POTION -> EntityTypes.AREA_EFFECT_CLOUD
        EntityType.FISHING_HOOK -> EntityTypes.FISHING_HOOK
        EntityType.LIGHTNING -> EntityTypes.LIGHTNING
        EntityType.WEATHER -> EntityTypes.WEATHER
        EntityType.PLAYER -> EntityTypes.PLAYER
        EntityType.COMPLEX_PART -> EntityTypes.COMPLEX_PART
        EntityType.TIPPED_ARROW -> EntityTypes.TIPPED_ARROW
        EntityType.UNKNOWN -> EntityTypes.UNKNOWN
    }
})

fun EntityType.sEntityType(): SEntityType = entityTypeMap.getValue(this)

fun SEntityType.bEntityType(): EntityType = entityTypeMap.inverse()[this] ?: EntityType.UNKNOWN //todo modded