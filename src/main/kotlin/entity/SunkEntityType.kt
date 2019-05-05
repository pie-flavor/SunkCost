package flavor.pie.sunkcost.entity

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
import org.bukkit.entity.minecart.HopperMinecart
import org.spongepowered.api.entity.EntityTypes
import org.spongepowered.api.entity.explosive.PrimedTNT
import org.spongepowered.api.entity.vehicle.minecart.ChestMinecart
import org.spongepowered.api.entity.vehicle.minecart.FurnaceMinecart
import org.spongepowered.api.entity.vehicle.minecart.MobSpawnerMinecart
import org.spongepowered.api.entity.vehicle.minecart.TNTMinecart
import org.spongepowered.api.entity.EntityType as SEntityType

fun Class<out Entity>.entityType(): EntityType = when (this) {
    Item::class.java -> EntityType.DROPPED_ITEM
    ExperienceOrb::class.java -> EntityType.EXPERIENCE_ORB
    AreaEffectCloud::class.java -> EntityType.AREA_EFFECT_CLOUD
    ElderGuardian::class.java -> EntityType.ELDER_GUARDIAN
    WitherSkeleton::class.java -> EntityType.WITHER_SKELETON
    Stray::class.java -> EntityType.STRAY
    Egg::class.java -> EntityType.EGG
    LeashHitch::class.java -> EntityType.LEASH_HITCH
    Painting::class.java -> EntityType.PAINTING
    Arrow::class.java -> EntityType.ARROW
    Snowball::class.java -> EntityType.SNOWBALL
    Fireball::class.java -> EntityType.FIREBALL
    SmallFireball::class.java -> EntityType.SMALL_FIREBALL
    EnderPearl::class.java -> EntityType.ENDER_PEARL
    EnderSignal::class.java -> EntityType.ENDER_SIGNAL
    SplashPotion::class.java -> EntityType.SPLASH_POTION
    ThrownExpBottle::class.java -> EntityType.THROWN_EXP_BOTTLE
    ItemFrame::class.java -> EntityType.ITEM_FRAME
    WitherSkull::class.java -> EntityType.WITHER_SKULL
    PrimedTNT::class.java -> EntityType.PRIMED_TNT
    FallingBlock::class.java -> EntityType.FALLING_BLOCK
    Firework::class.java -> EntityType.FIREWORK
    Husk::class.java -> EntityType.HUSK
    SpectralArrow::class.java -> EntityType.SPECTRAL_ARROW
    ShulkerBullet::class.java -> EntityType.SHULKER_BULLET
    DragonFireball::class.java -> EntityType.DRAGON_FIREBALL
    ZombieVillager::class.java -> EntityType.ZOMBIE_VILLAGER
    SkeletonHorse::class.java -> EntityType.SKELETON_HORSE
    ZombieHorse::class.java -> EntityType.ZOMBIE_HORSE
    ArmorStand::class.java -> EntityType.ARMOR_STAND
    Donkey::class.java -> EntityType.DONKEY
    Mule::class.java -> EntityType.MULE
    EvokerFangs::class.java -> EntityType.EVOKER_FANGS
    Evoker::class.java -> EntityType.EVOKER
    Vex::class.java -> EntityType.VEX
    Vindicator::class.java -> EntityType.VINDICATOR
    Illusioner::class.java -> EntityType.ILLUSIONER
    CommandMinecart::class.java -> EntityType.MINECART_COMMAND
    Boat::class.java -> EntityType.BOAT
    Minecart::class.java -> EntityType.MINECART
    ChestMinecart::class.java -> EntityType.MINECART_CHEST
    FurnaceMinecart::class.java -> EntityType.MINECART_FURNACE
    TNTMinecart::class.java-> EntityType.MINECART_TNT
    HopperMinecart::class.java -> EntityType.MINECART_HOPPER
    MobSpawnerMinecart::class.java -> EntityType.MINECART_MOB_SPAWNER
    Creeper::class.java -> EntityType.CREEPER
    Skeleton::class.java -> EntityType.SKELETON
    Spider::class.java -> EntityType.SPIDER
    Giant::class.java -> EntityType.GIANT
    Zombie::class.java -> EntityType.ZOMBIE
    Slime::class.java -> EntityType.SLIME
    Ghast::class.java-> EntityType.GHAST
    PigZombie::class.java -> EntityType.PIG_ZOMBIE
    Enderman::class.java -> EntityType.ENDERMAN
    CaveSpider::class.java -> EntityType.CAVE_SPIDER
    Silverfish::class.java -> EntityType.SILVERFISH
    Blaze::class.java -> EntityType.BLAZE
    MagmaCube::class.java -> EntityType.MAGMA_CUBE
    EnderDragon::class.java -> EntityType.ENDER_DRAGON
    Wither::class.java -> EntityType.WITHER
    Bat::class.java -> EntityType.BAT
    Witch::class.java -> EntityType.WITCH
    Endermite::class.java -> EntityType.ENDERMITE
    Guardian::class.java -> EntityType.GUARDIAN
    Shulker::class.java -> EntityType.SHULKER
    Pig::class.java -> EntityType.PIG
    Sheep::class.java -> EntityType.SHEEP
    Cow::class.java -> EntityType.COW
    Chicken::class.java -> EntityType.CHICKEN
    Squid::class.java -> EntityType.SQUID
    Wolf::class.java -> EntityType.WOLF
    MushroomCow::class.java -> EntityType.MUSHROOM_COW
    Snowman::class.java -> EntityType.SNOWMAN
    Ocelot::class.java -> EntityType.OCELOT
    IronGolem::class.java -> EntityType.IRON_GOLEM
    Horse::class.java -> EntityType.HORSE
    Rabbit::class.java -> EntityType.RABBIT
    PolarBear::class.java -> EntityType.POLAR_BEAR
    Llama::class.java -> EntityType.LLAMA
    LlamaSpit::class.java -> EntityType.LLAMA_SPIT
    Parrot::class.java -> EntityType.PARROT
    Villager::class.java -> EntityType.VILLAGER
    EnderCrystal::class.java -> EntityType.ENDER_CRYSTAL
    LingeringPotion::class.java -> EntityType.LINGERING_POTION
    FishHook::class.java -> EntityType.FISHING_HOOK
    LightningStrike::class.java -> EntityType.LIGHTNING
    Weather::class.java -> EntityType.WEATHER
    Player::class.java -> EntityType.PLAYER
    ComplexEntityPart::class.java -> EntityType.COMPLEX_PART
    TippedArrow::class.java -> EntityType.TIPPED_ARROW
    else -> EntityType.UNKNOWN
}

fun EntityType.sEntityType(): SEntityType = when (this) {
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

fun SEntityType.bEntityType(): EntityType = when (this) {
    EntityTypes.ITEM -> EntityType.DROPPED_ITEM
    EntityTypes.EXPERIENCE_ORB -> EntityType.EXPERIENCE_ORB
    EntityTypes.AREA_EFFECT_CLOUD -> EntityType.AREA_EFFECT_CLOUD
    EntityTypes.ELDER_GUARDIAN -> EntityType.ELDER_GUARDIAN
    EntityTypes.WITHER_SKELETON -> EntityType.WITHER_SKELETON
    EntityTypes.STRAY -> EntityType.STRAY
    EntityTypes.EGG -> EntityType.EGG
    EntityTypes.LEASH_HITCH -> EntityType.LEASH_HITCH
    EntityTypes.PAINTING -> EntityType.PAINTING
    EntityTypes.TIPPED_ARROW -> EntityType.ARROW
    EntityTypes.SNOWBALL -> EntityType.SNOWBALL
    EntityTypes.FIREBALL -> EntityType.FIREBALL
    EntityTypes.SMALL_FIREBALL -> EntityType.SMALL_FIREBALL
    EntityTypes.ENDER_PEARL -> EntityType.ENDER_PEARL
    EntityTypes.EYE_OF_ENDER -> EntityType.ENDER_SIGNAL
    EntityTypes.SPLASH_POTION -> EntityType.SPLASH_POTION
    EntityTypes.THROWN_EXP_BOTTLE -> EntityType.THROWN_EXP_BOTTLE
    EntityTypes.ITEM_FRAME -> EntityType.ITEM_FRAME
    EntityTypes.WITHER_SKULL -> EntityType.WITHER_SKULL
    EntityTypes.PRIMED_TNT -> EntityType.PRIMED_TNT
    EntityTypes.FALLING_BLOCK -> EntityType.FALLING_BLOCK
    EntityTypes.FIREWORK -> EntityType.FIREWORK
    EntityTypes.HUSK -> EntityType.HUSK
    EntityTypes.SPECTRAL_ARROW -> EntityType.SPECTRAL_ARROW
    EntityTypes.SHULKER_BULLET -> EntityType.SHULKER_BULLET
    EntityTypes.DRAGON_FIREBALL -> EntityType.DRAGON_FIREBALL
    EntityTypes.ZOMBIE_VILLAGER -> EntityType.ZOMBIE_VILLAGER
    EntityTypes.SKELETON_HORSE -> EntityType.SKELETON_HORSE
    EntityTypes.ZOMBIE_HORSE -> EntityType.ZOMBIE_HORSE
    EntityTypes.ARMOR_STAND -> EntityType.ARMOR_STAND
    EntityTypes.DONKEY -> EntityType.DONKEY
    EntityTypes.MULE -> EntityType.MULE
    EntityTypes.EVOCATION_FANGS -> EntityType.EVOKER_FANGS
    EntityTypes.EVOCATION_ILLAGER -> EntityType.EVOKER
    EntityTypes.VEX -> EntityType.VEX
    EntityTypes.VINDICATION_ILLAGER -> EntityType.VINDICATOR
    EntityTypes.ILLUSION_ILLAGER -> EntityType.ILLUSIONER
    EntityTypes.COMMANDBLOCK_MINECART -> EntityType.MINECART_COMMAND
    EntityTypes.BOAT -> EntityType.BOAT
    EntityTypes.RIDEABLE_MINECART -> EntityType.MINECART
    EntityTypes.CHESTED_MINECART -> EntityType.MINECART_CHEST
    EntityTypes.FURNACE_MINECART -> EntityType.MINECART_FURNACE
    EntityTypes.TNT_MINECART -> EntityType.MINECART_TNT
    EntityTypes.HOPPER_MINECART -> EntityType.MINECART_HOPPER
    EntityTypes.MOB_SPAWNER_MINECART -> EntityType.MINECART_MOB_SPAWNER
    EntityTypes.CREEPER -> EntityType.CREEPER
    EntityTypes.SKELETON -> EntityType.SKELETON
    EntityTypes.SPIDER -> EntityType.SPIDER
    EntityTypes.GIANT -> EntityType.GIANT
    EntityTypes.ZOMBIE -> EntityType.ZOMBIE
    EntityTypes.SLIME -> EntityType.SLIME
    EntityTypes.GHAST -> EntityType.GHAST
    EntityTypes.PIG_ZOMBIE -> EntityType.PIG_ZOMBIE
    EntityTypes.ENDERMAN -> EntityType.ENDERMAN
    EntityTypes.CAVE_SPIDER -> EntityType.CAVE_SPIDER
    EntityTypes.SILVERFISH -> EntityType.SILVERFISH
    EntityTypes.BLAZE -> EntityType.BLAZE
    EntityTypes.MAGMA_CUBE -> EntityType.MAGMA_CUBE
    EntityTypes.ENDER_DRAGON -> EntityType.ENDER_DRAGON
    EntityTypes.WITHER -> EntityType.WITHER
    EntityTypes.BAT -> EntityType.BAT
    EntityTypes.WITCH -> EntityType.WITCH
    EntityTypes.ENDERMITE -> EntityType.ENDERMITE
    EntityTypes.GUARDIAN -> EntityType.GUARDIAN
    EntityTypes.SHULKER -> EntityType.SHULKER
    EntityTypes.PIG -> EntityType.PIG
    EntityTypes.SHEEP -> EntityType.SHEEP
    EntityTypes.COW -> EntityType.COW
    EntityTypes.CHICKEN -> EntityType.CHICKEN
    EntityTypes.SQUID -> EntityType.SQUID
    EntityTypes.WOLF -> EntityType.WOLF
    EntityTypes.MUSHROOM_COW -> EntityType.MUSHROOM_COW
    EntityTypes.SNOWMAN -> EntityType.SNOWMAN
    EntityTypes.OCELOT -> EntityType.OCELOT
    EntityTypes.IRON_GOLEM -> EntityType.IRON_GOLEM
    EntityTypes.HORSE -> EntityType.HORSE
    EntityTypes.RABBIT -> EntityType.RABBIT
    EntityTypes.POLAR_BEAR -> EntityType.POLAR_BEAR
    EntityTypes.LLAMA -> EntityType.LLAMA
    EntityTypes.LLAMA_SPIT -> EntityType.LLAMA_SPIT
    EntityTypes.PARROT -> EntityType.PARROT
    EntityTypes.VILLAGER -> EntityType.VILLAGER
    EntityTypes.ENDER_CRYSTAL -> EntityType.ENDER_CRYSTAL
    EntityTypes.AREA_EFFECT_CLOUD -> EntityType.LINGERING_POTION
    EntityTypes.FISHING_HOOK -> EntityType.FISHING_HOOK
    EntityTypes.LIGHTNING -> EntityType.LIGHTNING
    EntityTypes.WEATHER -> EntityType.WEATHER
    EntityTypes.PLAYER -> EntityType.PLAYER
    EntityTypes.COMPLEX_PART -> EntityType.COMPLEX_PART
    EntityTypes.TIPPED_ARROW -> EntityType.TIPPED_ARROW
    else -> EntityType.UNKNOWN
    //todo modded
}