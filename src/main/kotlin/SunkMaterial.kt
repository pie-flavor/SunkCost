package flavor.pie.sunkcost

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.Material
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.block.BlockTypes
import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.ItemTypes

private val itemTypeMap: BiMap<Material, ItemType> =
    HashBiMap.create(Material.values().filter { it.isItem }.associateWith {
        when (it) {
            Material.AIR -> ItemTypes.AIR
            Material.STONE -> ItemTypes.STONE
            Material.GRASS -> ItemTypes.GRASS
            Material.DIRT -> ItemTypes.DIRT
            Material.COBBLESTONE -> ItemTypes.COBBLESTONE
            Material.WOOD -> ItemTypes.LOG
            Material.SAPLING -> ItemTypes.SAPLING
            Material.BEDROCK -> ItemTypes.BEDROCK
//        Material.WATER -> null
//        Material.STATIONARY_WATER -> null
//        Material.LAVA -> null
//        Material.STATIONARY_LAVA -> null
            Material.SAND -> ItemTypes.SAND
            Material.GRAVEL -> ItemTypes.GRAVEL
            Material.GOLD_ORE -> ItemTypes.GOLD_ORE
            Material.IRON_ORE -> ItemTypes.IRON_ORE
            Material.COAL_ORE -> ItemTypes.COAL_ORE
            Material.LOG -> ItemTypes.LOG
            Material.LEAVES -> ItemTypes.LEAVES
            Material.SPONGE -> ItemTypes.SPONGE
            Material.GLASS -> ItemTypes.GLASS
            Material.LAPIS_ORE -> ItemTypes.LAPIS_ORE
            Material.LAPIS_BLOCK -> ItemTypes.LAPIS_BLOCK
            Material.DISPENSER -> ItemTypes.DISPENSER
            Material.SANDSTONE -> ItemTypes.SANDSTONE
            Material.NOTE_BLOCK -> ItemTypes.NOTEBLOCK
//        Material.BED_BLOCK -> ItemTypes.BED
            Material.POWERED_RAIL -> ItemTypes.GOLDEN_RAIL
            Material.DETECTOR_RAIL -> ItemTypes.DETECTOR_RAIL
            Material.PISTON_STICKY_BASE -> ItemTypes.STICKY_PISTON
            Material.WEB -> ItemTypes.WEB
            Material.LONG_GRASS -> ItemTypes.TALLGRASS
            Material.DEAD_BUSH -> ItemTypes.DEADBUSH
            Material.PISTON_BASE -> ItemTypes.PISTON
//        Material.PISTON_EXTENSION -> ItemTypes.PISTON
            Material.WOOL -> ItemTypes.WOOL
//        Material.PISTON_MOVING_PIECE -> ItemTypes.PISTON
            Material.YELLOW_FLOWER -> ItemTypes.YELLOW_FLOWER
            Material.RED_ROSE -> ItemTypes.RED_FLOWER
            Material.BROWN_MUSHROOM -> ItemTypes.BROWN_MUSHROOM
            Material.RED_MUSHROOM -> ItemTypes.RED_MUSHROOM
            Material.GOLD_BLOCK -> ItemTypes.GOLD_BLOCK
            Material.IRON_BLOCK -> ItemTypes.IRON_BLOCK
//        Material.DOUBLE_STEP -> ItemTypes.STONE_SLAB
            Material.STEP -> ItemTypes.STONE_SLAB
            Material.BRICK -> ItemTypes.BRICK
            Material.TNT -> ItemTypes.TNT
            Material.BOOKSHELF -> ItemTypes.BOOKSHELF
            Material.MOSSY_COBBLESTONE -> ItemTypes.MOSSY_COBBLESTONE
            Material.OBSIDIAN -> ItemTypes.OBSIDIAN
            Material.TORCH -> ItemTypes.TORCH
//        Material.FIRE -> null
            Material.MOB_SPAWNER -> ItemTypes.MOB_SPAWNER
            Material.WOOD_STAIRS -> ItemTypes.OAK_STAIRS
            Material.CHEST -> ItemTypes.CHEST
//        Material.REDSTONE_WIRE -> ItemTypes.REDSTONE
            Material.DIAMOND_ORE -> ItemTypes.DIAMOND_ORE
            Material.DIAMOND_BLOCK -> ItemTypes.DIAMOND_BLOCK
            Material.WORKBENCH -> ItemTypes.CRAFTING_TABLE
//        Material.CROPS -> ItemTypes.WHEAT_SEEDS
            Material.SOIL -> ItemTypes.FARMLAND
            Material.FURNACE -> ItemTypes.FURNACE
            Material.BURNING_FURNACE -> ItemTypes.FURNACE
//        Material.SIGN_POST -> ItemTypes.SIGN
//        Material.WOODEN_DOOR -> ItemTypes.WOODEN_DOOR
            Material.LADDER -> ItemTypes.LADDER
            Material.RAILS -> ItemTypes.RAIL
            Material.COBBLESTONE_STAIRS -> ItemTypes.STONE_STAIRS
//        Material.WALL_SIGN -> ItemTypes.SIGN
            Material.LEVER -> ItemTypes.LEVER
            Material.STONE_PLATE -> ItemTypes.STONE_PRESSURE_PLATE
//        Material.IRON_DOOR_BLOCK -> ItemTypes.IRON_DOOR
            Material.WOOD_PLATE -> ItemTypes.WOODEN_PRESSURE_PLATE
            Material.REDSTONE_ORE -> ItemTypes.REDSTONE_ORE
//        Material.GLOWING_REDSTONE_ORE -> ItemTypes.REDSTONE_ORE
//        Material.REDSTONE_TORCH_OFF -> ItemTypes.REDSTONE_TORCH
            Material.REDSTONE_TORCH_ON -> ItemTypes.REDSTONE_TORCH
            Material.STONE_BUTTON -> ItemTypes.STONE_BUTTON
            Material.SNOW -> ItemTypes.SNOW
            Material.ICE -> ItemTypes.ICE
            Material.SNOW_BLOCK -> ItemTypes.SNOW
            Material.CACTUS -> ItemTypes.CACTUS
            Material.CLAY -> ItemTypes.CLAY
//        Material.SUGAR_CANE_BLOCK -> ItemTypes.REEDS
            Material.JUKEBOX -> ItemTypes.JUKEBOX
            Material.FENCE -> ItemTypes.FENCE
            Material.PUMPKIN -> ItemTypes.PUMPKIN
            Material.NETHERRACK -> ItemTypes.NETHERRACK
            Material.SOUL_SAND -> ItemTypes.SOUL_SAND
            Material.GLOWSTONE -> ItemTypes.GLOWSTONE
//        Material.PORTAL -> null
            Material.JACK_O_LANTERN -> ItemTypes.LIT_PUMPKIN
//        Material.CAKE_BLOCK -> ItemTypes.CAKE
//        Material.DIODE_BLOCK_OFF -> ItemTypes.REPEATER
//        Material.DIODE_BLOCK_ON -> ItemTypes.REPEATER
            Material.STAINED_GLASS -> ItemTypes.STAINED_GLASS
            Material.TRAP_DOOR -> ItemTypes.TRAPDOOR
            Material.MONSTER_EGGS -> ItemTypes.MONSTER_EGG
            Material.SMOOTH_BRICK -> ItemTypes.STONEBRICK
            Material.HUGE_MUSHROOM_1 -> ItemTypes.BROWN_MUSHROOM_BLOCK
            Material.HUGE_MUSHROOM_2 -> ItemTypes.RED_MUSHROOM_BLOCK
            Material.IRON_FENCE -> ItemTypes.IRON_BARS
            Material.THIN_GLASS -> ItemTypes.GLASS_PANE
            Material.MELON_BLOCK -> ItemTypes.MELON_BLOCK
//        Material.PUMPKIN_STEM -> ItemTypes.PUMPKIN_SEEDS
//        Material.MELON_STEM -> ItemTypes.MELON_SEEDS
            Material.VINE -> ItemTypes.VINE
            Material.FENCE_GATE -> ItemTypes.FENCE_GATE
            Material.BRICK_STAIRS -> ItemTypes.BRICK_STAIRS
            Material.SMOOTH_STAIRS -> ItemTypes.STONE_BRICK_STAIRS
            Material.MYCEL -> ItemTypes.MYCELIUM
            Material.WATER_LILY -> ItemTypes.WATERLILY
            Material.NETHER_BRICK -> ItemTypes.NETHER_BRICK
            Material.NETHER_FENCE -> ItemTypes.NETHER_BRICK_FENCE
            Material.NETHER_BRICK_STAIRS -> ItemTypes.NETHER_BRICK_STAIRS
//        Material.NETHER_WARTS -> ItemTypes.NETHER_WART
            Material.ENCHANTMENT_TABLE -> ItemTypes.ENCHANTING_TABLE
            Material.BREWING_STAND -> ItemTypes.BREWING_STAND
//        Material.CAULDRON -> ItemTypes.CAULDRON
//        Material.ENDER_PORTAL -> null
            Material.ENDER_PORTAL_FRAME -> ItemTypes.END_PORTAL_FRAME
            Material.ENDER_STONE -> ItemTypes.END_STONE
            Material.DRAGON_EGG -> ItemTypes.DRAGON_EGG
            Material.REDSTONE_LAMP_OFF -> ItemTypes.REDSTONE_LAMP
//        Material.REDSTONE_LAMP_ON -> ItemTypes.REDSTONE_LAMP
//        Material.WOOD_DOUBLE_STEP -> ItemTypes.WOODEN_SLAB
            Material.WOOD_STEP -> ItemTypes.OAK_STAIRS
//        Material.COCOA -> ItemTypes.DYE
            Material.SANDSTONE_STAIRS -> ItemTypes.SANDSTONE_STAIRS
            Material.EMERALD_ORE -> ItemTypes.EMERALD_ORE
            Material.ENDER_CHEST -> ItemTypes.ENDER_CHEST
            Material.TRIPWIRE_HOOK -> ItemTypes.TRIPWIRE_HOOK
//        Material.TRIPWIRE -> ItemTypes.STRING
            Material.EMERALD_BLOCK -> ItemTypes.EMERALD_BLOCK
            Material.SPRUCE_WOOD_STAIRS -> ItemTypes.SPRUCE_STAIRS
            Material.BIRCH_WOOD_STAIRS -> ItemTypes.BIRCH_STAIRS
            Material.JUNGLE_WOOD_STAIRS -> ItemTypes.JUNGLE_STAIRS
            Material.COMMAND -> ItemTypes.COMMAND_BLOCK
            Material.BEACON -> ItemTypes.BEACON
            Material.COBBLE_WALL -> ItemTypes.COBBLESTONE_WALL
//        Material.FLOWER_POT -> ItemTypes.FLOWER_POT
//        Material.CARROT -> ItemTypes.CARROT
//        Material.POTATO -> ItemTypes.POTATO
            Material.WOOD_BUTTON -> ItemTypes.WOODEN_BUTTON
//        Material.SKULL -> ItemTypes.SKULL
            Material.ANVIL -> ItemTypes.ANVIL
            Material.TRAPPED_CHEST -> ItemTypes.TRAPPED_CHEST
            Material.GOLD_PLATE -> ItemTypes.LIGHT_WEIGHTED_PRESSURE_PLATE
            Material.IRON_PLATE -> ItemTypes.HEAVY_WEIGHTED_PRESSURE_PLATE
//        Material.REDSTONE_COMPARATOR_OFF -> ItemTypes.COMPARATOR
//        Material.REDSTONE_COMPARATOR_ON -> ItemTypes.COMPARATOR
            Material.DAYLIGHT_DETECTOR -> ItemTypes.DAYLIGHT_DETECTOR
            Material.REDSTONE_BLOCK -> ItemTypes.REDSTONE_BLOCK
            Material.QUARTZ_ORE -> ItemTypes.QUARTZ_ORE
            Material.HOPPER -> ItemTypes.HOPPER
            Material.QUARTZ_BLOCK -> ItemTypes.QUARTZ_BLOCK
            Material.QUARTZ_STAIRS -> ItemTypes.QUARTZ_STAIRS
            Material.ACTIVATOR_RAIL -> ItemTypes.ACTIVATOR_RAIL
            Material.DROPPER -> ItemTypes.DROPPER
            Material.STAINED_CLAY -> ItemTypes.STAINED_HARDENED_CLAY
            Material.STAINED_GLASS_PANE -> ItemTypes.STAINED_GLASS_PANE
            Material.LEAVES_2 -> ItemTypes.LEAVES2
            Material.LOG_2 -> ItemTypes.LOG2
            Material.ACACIA_STAIRS -> ItemTypes.ACACIA_STAIRS
            Material.DARK_OAK_STAIRS -> ItemTypes.DARK_OAK_STAIRS
            Material.SLIME_BLOCK -> ItemTypes.SLIME
            Material.BARRIER -> ItemTypes.BARRIER
            Material.IRON_TRAPDOOR -> ItemTypes.IRON_TRAPDOOR
            Material.PRISMARINE -> ItemTypes.PRISMARINE
            Material.SEA_LANTERN -> ItemTypes.SEA_LANTERN
            Material.HAY_BLOCK -> ItemTypes.HAY_BLOCK
            Material.CARPET -> ItemTypes.CARPET
            Material.HARD_CLAY -> ItemTypes.HARDENED_CLAY
            Material.COAL_BLOCK -> ItemTypes.COAL_BLOCK
            Material.PACKED_ICE -> ItemTypes.PACKED_ICE
            Material.DOUBLE_PLANT -> ItemTypes.DOUBLE_PLANT
//        Material.STANDING_BANNER -> ItemTypes.BANNER
//        Material.WALL_BANNER -> ItemTypes.BANNER
//        Material.DAYLIGHT_DETECTOR_INVERTED -> ItemTypes.DAYLIGHT_DETECTOR
            Material.RED_SANDSTONE -> ItemTypes.RED_SANDSTONE
            Material.RED_SANDSTONE_STAIRS -> ItemTypes.RED_SANDSTONE_STAIRS
//        Material.DOUBLE_STONE_SLAB2 -> ItemTypes.STONE_SLAB2
            Material.STONE_SLAB2 -> ItemTypes.STONE_SLAB2
            Material.SPRUCE_FENCE_GATE -> ItemTypes.SPRUCE_FENCE_GATE
            Material.BIRCH_FENCE_GATE -> ItemTypes.BIRCH_FENCE_GATE
            Material.JUNGLE_FENCE_GATE -> ItemTypes.JUNGLE_FENCE_GATE
            Material.DARK_OAK_FENCE_GATE -> ItemTypes.DARK_OAK_FENCE_GATE
            Material.ACACIA_FENCE_GATE -> ItemTypes.ACACIA_FENCE_GATE
            Material.SPRUCE_FENCE -> ItemTypes.SPRUCE_FENCE
            Material.BIRCH_FENCE -> ItemTypes.BIRCH_FENCE
            Material.JUNGLE_FENCE -> ItemTypes.JUNGLE_FENCE
            Material.DARK_OAK_FENCE -> ItemTypes.DARK_OAK_FENCE
            Material.ACACIA_FENCE -> ItemTypes.ACACIA_FENCE
//        Material.SPRUCE_DOOR -> ItemTypes.SPRUCE_DOOR
            Material.BIRCH_DOOR -> ItemTypes.BIRCH_DOOR
//        Material.JUNGLE_DOOR -> ItemTypes.JUNGLE_DOOR
//        Material.ACACIA_DOOR -> ItemTypes.ACACIA_DOOR
//        Material.DARK_OAK_DOOR -> ItemTypes.DARK_OAK_DOOR
            Material.END_ROD -> ItemTypes.END_ROD
            Material.CHORUS_PLANT -> ItemTypes.CHORUS_PLANT
            Material.CHORUS_FLOWER -> ItemTypes.CHORUS_FLOWER
            Material.PURPUR_BLOCK -> ItemTypes.PURPUR_BLOCK
            Material.PURPUR_PILLAR -> ItemTypes.PURPUR_PILLAR
            Material.PURPUR_STAIRS -> ItemTypes.PURPUR_STAIRS
//        Material.PURPUR_DOUBLE_SLAB -> ItemTypes.PURPUR_SLAB
            Material.PURPUR_SLAB -> ItemTypes.PURPUR_SLAB
            Material.END_BRICKS -> ItemTypes.END_BRICKS
//        Material.BEETROOT_BLOCK -> ItemTypes.BEETROOT
            Material.GRASS_PATH -> ItemTypes.GRASS_PATH
//        Material.END_GATEWAY -> null
            Material.COMMAND_REPEATING -> ItemTypes.REPEATING_COMMAND_BLOCK
            Material.COMMAND_CHAIN -> ItemTypes.CHAIN_COMMAND_BLOCK
//        Material.FROSTED_ICE -> ItemTypes.PACKED_ICE
            Material.MAGMA -> ItemTypes.MAGMA
            Material.NETHER_WART_BLOCK -> ItemTypes.NETHER_WART_BLOCK
            Material.RED_NETHER_BRICK -> ItemTypes.RED_NETHER_BRICK
            Material.BONE_BLOCK -> ItemTypes.BONE_BLOCK
            Material.STRUCTURE_VOID -> ItemTypes.STRUCTURE_VOID
            Material.OBSERVER -> ItemTypes.OBSERVER
            Material.WHITE_SHULKER_BOX -> ItemTypes.WHITE_SHULKER_BOX
            Material.ORANGE_SHULKER_BOX -> ItemTypes.ORANGE_SHULKER_BOX
            Material.MAGENTA_SHULKER_BOX -> ItemTypes.MAGENTA_SHULKER_BOX
            Material.LIGHT_BLUE_SHULKER_BOX -> ItemTypes.LIGHT_BLUE_SHULKER_BOX
            Material.YELLOW_SHULKER_BOX -> ItemTypes.YELLOW_SHULKER_BOX
            Material.LIME_SHULKER_BOX -> ItemTypes.LIME_SHULKER_BOX
            Material.PINK_SHULKER_BOX -> ItemTypes.PINK_SHULKER_BOX
            Material.GRAY_SHULKER_BOX -> ItemTypes.GRAY_SHULKER_BOX
            Material.SILVER_SHULKER_BOX -> ItemTypes.SILVER_SHULKER_BOX
            Material.CYAN_SHULKER_BOX -> ItemTypes.CYAN_SHULKER_BOX
            Material.PURPLE_SHULKER_BOX -> ItemTypes.PURPLE_SHULKER_BOX
            Material.BLUE_SHULKER_BOX -> ItemTypes.BLUE_SHULKER_BOX
            Material.BROWN_SHULKER_BOX -> ItemTypes.BROWN_SHULKER_BOX
            Material.GREEN_SHULKER_BOX -> ItemTypes.GREEN_SHULKER_BOX
            Material.RED_SHULKER_BOX -> ItemTypes.RED_SHULKER_BOX
            Material.BLACK_SHULKER_BOX -> ItemTypes.BLACK_SHULKER_BOX
            Material.WHITE_GLAZED_TERRACOTTA -> ItemTypes.WHITE_GLAZED_TERRACOTTA
            Material.ORANGE_GLAZED_TERRACOTTA -> ItemTypes.ORANGE_GLAZED_TERRACOTTA
            Material.MAGENTA_GLAZED_TERRACOTTA -> ItemTypes.MAGENTA_GLAZED_TERRACOTTA
            Material.LIGHT_BLUE_GLAZED_TERRACOTTA -> ItemTypes.LIGHT_BLUE_GLAZED_TERRACOTTA
            Material.YELLOW_GLAZED_TERRACOTTA -> ItemTypes.YELLOW_GLAZED_TERRACOTTA
            Material.LIME_GLAZED_TERRACOTTA -> ItemTypes.LIME_GLAZED_TERRACOTTA
            Material.PINK_GLAZED_TERRACOTTA -> ItemTypes.PINK_GLAZED_TERRACOTTA
            Material.GRAY_GLAZED_TERRACOTTA -> ItemTypes.GRAY_GLAZED_TERRACOTTA
            Material.SILVER_GLAZED_TERRACOTTA -> ItemTypes.SILVER_GLAZED_TERRACOTTA
            Material.CYAN_GLAZED_TERRACOTTA -> ItemTypes.CYAN_GLAZED_TERRACOTTA
            Material.PURPLE_GLAZED_TERRACOTTA -> ItemTypes.PURPLE_GLAZED_TERRACOTTA
            Material.BLUE_GLAZED_TERRACOTTA -> ItemTypes.BLUE_GLAZED_TERRACOTTA
            Material.BROWN_GLAZED_TERRACOTTA -> ItemTypes.BROWN_GLAZED_TERRACOTTA
            Material.GREEN_GLAZED_TERRACOTTA -> ItemTypes.GREEN_GLAZED_TERRACOTTA
            Material.RED_GLAZED_TERRACOTTA -> ItemTypes.RED_GLAZED_TERRACOTTA
            Material.BLACK_GLAZED_TERRACOTTA -> ItemTypes.BLACK_GLAZED_TERRACOTTA
            Material.CONCRETE -> ItemTypes.CONCRETE
            Material.CONCRETE_POWDER -> ItemTypes.CONCRETE_POWDER
            Material.STRUCTURE_BLOCK -> ItemTypes.STRUCTURE_BLOCK
            Material.IRON_SPADE -> ItemTypes.IRON_SHOVEL
            Material.IRON_PICKAXE -> ItemTypes.IRON_PICKAXE
            Material.IRON_AXE -> ItemTypes.IRON_AXE
            Material.FLINT_AND_STEEL -> ItemTypes.FLINT_AND_STEEL
            Material.APPLE -> ItemTypes.APPLE
            Material.BOW -> ItemTypes.BOW
            Material.ARROW -> ItemTypes.ARROW
            Material.COAL -> ItemTypes.COAL
            Material.DIAMOND -> ItemTypes.DIAMOND
            Material.IRON_INGOT -> ItemTypes.IRON_INGOT
            Material.GOLD_INGOT -> ItemTypes.GOLD_INGOT
            Material.IRON_SWORD -> ItemTypes.IRON_SWORD
            Material.WOOD_SWORD -> ItemTypes.WOODEN_SWORD
            Material.WOOD_SPADE -> ItemTypes.WOODEN_SHOVEL
            Material.WOOD_PICKAXE -> ItemTypes.WOODEN_PICKAXE
            Material.WOOD_AXE -> ItemTypes.WOODEN_AXE
            Material.STONE_SWORD -> ItemTypes.STONE_SWORD
            Material.STONE_SPADE -> ItemTypes.STONE_SHOVEL
            Material.STONE_PICKAXE -> ItemTypes.STONE_PICKAXE
            Material.STONE_AXE -> ItemTypes.STONE_AXE
            Material.DIAMOND_SWORD -> ItemTypes.DIAMOND_SWORD
            Material.DIAMOND_SPADE -> ItemTypes.DIAMOND_SHOVEL
            Material.DIAMOND_PICKAXE -> ItemTypes.DIAMOND_PICKAXE
            Material.DIAMOND_AXE -> ItemTypes.DIAMOND_AXE
            Material.STICK -> ItemTypes.STICK
            Material.BOWL -> ItemTypes.BOWL
            Material.MUSHROOM_SOUP -> ItemTypes.MUSHROOM_STEW
            Material.GOLD_SWORD -> ItemTypes.GOLDEN_SWORD
            Material.GOLD_SPADE -> ItemTypes.GOLDEN_SHOVEL
            Material.GOLD_PICKAXE -> ItemTypes.GOLDEN_PICKAXE
            Material.GOLD_AXE -> ItemTypes.GOLDEN_AXE
            Material.STRING -> ItemTypes.STRING
            Material.FEATHER -> ItemTypes.FEATHER
            Material.SULPHUR -> ItemTypes.GUNPOWDER
            Material.WOOD_HOE -> ItemTypes.WOODEN_HOE
            Material.STONE_HOE -> ItemTypes.STONE_HOE
            Material.IRON_HOE -> ItemTypes.IRON_HOE
            Material.DIAMOND_HOE -> ItemTypes.DIAMOND_HOE
            Material.GOLD_HOE -> ItemTypes.GOLDEN_HOE
            Material.SEEDS -> ItemTypes.WHEAT_SEEDS
            Material.WHEAT -> ItemTypes.WHEAT
            Material.BREAD -> ItemTypes.BREAD
            Material.LEATHER_HELMET -> ItemTypes.LEATHER_HELMET
            Material.LEATHER_CHESTPLATE -> ItemTypes.LEATHER_CHESTPLATE
            Material.LEATHER_LEGGINGS -> ItemTypes.LEATHER_LEGGINGS
            Material.LEATHER_BOOTS -> ItemTypes.LEATHER_BOOTS
            Material.CHAINMAIL_HELMET -> ItemTypes.CHAINMAIL_HELMET
            Material.CHAINMAIL_CHESTPLATE -> ItemTypes.CHAINMAIL_CHESTPLATE
            Material.CHAINMAIL_LEGGINGS -> ItemTypes.CHAINMAIL_LEGGINGS
            Material.CHAINMAIL_BOOTS -> ItemTypes.CHAINMAIL_BOOTS
            Material.IRON_HELMET -> ItemTypes.IRON_HELMET
            Material.IRON_CHESTPLATE -> ItemTypes.IRON_CHESTPLATE
            Material.IRON_LEGGINGS -> ItemTypes.IRON_LEGGINGS
            Material.IRON_BOOTS -> ItemTypes.IRON_BOOTS
            Material.DIAMOND_HELMET -> ItemTypes.DIAMOND_HELMET
            Material.DIAMOND_CHESTPLATE -> ItemTypes.DIAMOND_CHESTPLATE
            Material.DIAMOND_LEGGINGS -> ItemTypes.DIAMOND_LEGGINGS
            Material.DIAMOND_BOOTS -> ItemTypes.DIAMOND_BOOTS
            Material.GOLD_HELMET -> ItemTypes.GOLDEN_HELMET
            Material.GOLD_CHESTPLATE -> ItemTypes.GOLDEN_CHESTPLATE
            Material.GOLD_LEGGINGS -> ItemTypes.GOLDEN_LEGGINGS
            Material.GOLD_BOOTS -> ItemTypes.GOLDEN_BOOTS
            Material.FLINT -> ItemTypes.FLINT
            Material.PORK -> ItemTypes.PORKCHOP
            Material.GRILLED_PORK -> ItemTypes.COOKED_PORKCHOP
            Material.PAINTING -> ItemTypes.PAINTING
            Material.GOLDEN_APPLE -> ItemTypes.GOLDEN_APPLE
            Material.SIGN -> ItemTypes.SIGN
            Material.WOOD_DOOR -> ItemTypes.WOODEN_DOOR
            Material.BUCKET -> ItemTypes.BUCKET
            Material.WATER_BUCKET -> ItemTypes.WATER_BUCKET
            Material.LAVA_BUCKET -> ItemTypes.LAVA_BUCKET
            Material.MINECART -> ItemTypes.MINECART
            Material.SADDLE -> ItemTypes.SADDLE
            Material.IRON_DOOR -> ItemTypes.IRON_DOOR
            Material.REDSTONE -> ItemTypes.REDSTONE
            Material.SNOW_BALL -> ItemTypes.SNOWBALL
            Material.BOAT -> ItemTypes.BOAT
            Material.LEATHER -> ItemTypes.LEATHER
            Material.MILK_BUCKET -> ItemTypes.MILK_BUCKET
            Material.CLAY_BRICK -> ItemTypes.BRICK
            Material.CLAY_BALL -> ItemTypes.CLAY_BALL
            Material.SUGAR_CANE -> ItemTypes.REEDS
            Material.PAPER -> ItemTypes.PAPER
            Material.BOOK -> ItemTypes.BOOK
            Material.SLIME_BALL -> ItemTypes.SLIME_BALL
            Material.STORAGE_MINECART -> ItemTypes.CHEST_MINECART
            Material.POWERED_MINECART -> ItemTypes.FURNACE_MINECART
            Material.EGG -> ItemTypes.EGG
            Material.COMPASS -> ItemTypes.COMPASS
            Material.FISHING_ROD -> ItemTypes.FISHING_ROD
            Material.WATCH -> ItemTypes.CLOCK
            Material.GLOWSTONE_DUST -> ItemTypes.GLOWSTONE_DUST
            Material.RAW_FISH -> ItemTypes.FISH
            Material.COOKED_FISH -> ItemTypes.COOKED_FISH
            Material.INK_SACK -> ItemTypes.DYE
            Material.BONE -> ItemTypes.BONE
            Material.SUGAR -> ItemTypes.SUGAR
            Material.CAKE -> ItemTypes.CAKE
            Material.BED -> ItemTypes.BED
            Material.DIODE -> ItemTypes.REPEATER
            Material.COOKIE -> ItemTypes.COOKIE
            Material.MAP -> ItemTypes.MAP
            Material.SHEARS -> ItemTypes.SHEARS
            Material.MELON -> ItemTypes.MELON
            Material.PUMPKIN_SEEDS -> ItemTypes.PUMPKIN_SEEDS
            Material.MELON_SEEDS -> ItemTypes.MELON_SEEDS
            Material.RAW_BEEF -> ItemTypes.BEEF
            Material.COOKED_BEEF -> ItemTypes.COOKED_BEEF
            Material.RAW_CHICKEN -> ItemTypes.CHICKEN
            Material.COOKED_CHICKEN -> ItemTypes.COOKED_CHICKEN
            Material.ROTTEN_FLESH -> ItemTypes.ROTTEN_FLESH
            Material.ENDER_PEARL -> ItemTypes.ENDER_PEARL
            Material.BLAZE_ROD -> ItemTypes.BLAZE_ROD
            Material.GHAST_TEAR -> ItemTypes.GHAST_TEAR
            Material.GOLD_NUGGET -> ItemTypes.GOLD_NUGGET
            Material.NETHER_STALK -> ItemTypes.NETHER_WART
            Material.POTION -> ItemTypes.POTION
            Material.GLASS_BOTTLE -> ItemTypes.GLASS_BOTTLE
            Material.SPIDER_EYE -> ItemTypes.SPIDER_EYE
            Material.FERMENTED_SPIDER_EYE -> ItemTypes.FERMENTED_SPIDER_EYE
            Material.BLAZE_POWDER -> ItemTypes.BLAZE_POWDER
            Material.MAGMA_CREAM -> ItemTypes.MAGMA_CREAM
            Material.BREWING_STAND_ITEM -> ItemTypes.BREWING_STAND
            Material.CAULDRON_ITEM -> ItemTypes.CAULDRON
            Material.EYE_OF_ENDER -> ItemTypes.ENDER_EYE
            Material.SPECKLED_MELON -> ItemTypes.SPECKLED_MELON
            Material.MONSTER_EGG -> ItemTypes.MONSTER_EGG
            Material.EXP_BOTTLE -> ItemTypes.EXPERIENCE_BOTTLE
            Material.FIREBALL -> ItemTypes.FIRE_CHARGE
            Material.BOOK_AND_QUILL -> ItemTypes.WRITABLE_BOOK
            Material.WRITTEN_BOOK -> ItemTypes.WRITTEN_BOOK
            Material.EMERALD -> ItemTypes.EMERALD
            Material.ITEM_FRAME -> ItemTypes.ITEM_FRAME
            Material.FLOWER_POT_ITEM -> ItemTypes.FLOWER_POT
            Material.CARROT_ITEM -> ItemTypes.CARROT
            Material.POTATO_ITEM -> ItemTypes.POTATO
            Material.BAKED_POTATO -> ItemTypes.BAKED_POTATO
            Material.POISONOUS_POTATO -> ItemTypes.POISONOUS_POTATO
            Material.EMPTY_MAP -> ItemTypes.MAP
            Material.GOLDEN_CARROT -> ItemTypes.GOLDEN_CARROT
            Material.SKULL_ITEM -> ItemTypes.SKULL
            Material.CARROT_STICK -> ItemTypes.CARROT_ON_A_STICK
            Material.NETHER_STAR -> ItemTypes.NETHER_STAR
            Material.PUMPKIN_PIE -> ItemTypes.PUMPKIN_PIE
            Material.FIREWORK -> ItemTypes.FIREWORKS
            Material.FIREWORK_CHARGE -> ItemTypes.FIREWORK_CHARGE
            Material.ENCHANTED_BOOK -> ItemTypes.ENCHANTED_BOOK
            Material.REDSTONE_COMPARATOR -> ItemTypes.COMPARATOR
            Material.NETHER_BRICK_ITEM -> ItemTypes.NETHER_BRICK
            Material.QUARTZ -> ItemTypes.QUARTZ
            Material.EXPLOSIVE_MINECART -> ItemTypes.TNT_MINECART
            Material.HOPPER_MINECART -> ItemTypes.HOPPER_MINECART
            Material.PRISMARINE_SHARD -> ItemTypes.PRISMARINE_SHARD
            Material.PRISMARINE_CRYSTALS -> ItemTypes.PRISMARINE_CRYSTALS
            Material.RABBIT -> ItemTypes.RABBIT
            Material.COOKED_RABBIT -> ItemTypes.COOKED_RABBIT
            Material.RABBIT_STEW -> ItemTypes.RABBIT_STEW
            Material.RABBIT_FOOT -> ItemTypes.RABBIT_FOOT
            Material.RABBIT_HIDE -> ItemTypes.RABBIT_HIDE
            Material.ARMOR_STAND -> ItemTypes.ARMOR_STAND
            Material.IRON_BARDING -> ItemTypes.IRON_HORSE_ARMOR
            Material.GOLD_BARDING -> ItemTypes.GOLDEN_HORSE_ARMOR
            Material.DIAMOND_BARDING -> ItemTypes.DIAMOND_HORSE_ARMOR
            Material.LEASH -> ItemTypes.LEAD
            Material.NAME_TAG -> ItemTypes.NAME_TAG
            Material.COMMAND_MINECART -> ItemTypes.COMMAND_BLOCK_MINECART
            Material.MUTTON -> ItemTypes.MUTTON
            Material.COOKED_MUTTON -> ItemTypes.COOKED_MUTTON
            Material.BANNER -> ItemTypes.BANNER
            Material.END_CRYSTAL -> ItemTypes.END_CRYSTAL
            Material.SPRUCE_DOOR_ITEM -> ItemTypes.SPRUCE_DOOR
            Material.BIRCH_DOOR_ITEM -> ItemTypes.BIRCH_DOOR
            Material.JUNGLE_DOOR_ITEM -> ItemTypes.JUNGLE_DOOR
            Material.ACACIA_DOOR_ITEM -> ItemTypes.ACACIA_DOOR
            Material.DARK_OAK_DOOR_ITEM -> ItemTypes.DARK_OAK_DOOR
            Material.CHORUS_FRUIT -> ItemTypes.CHORUS_FRUIT
            Material.CHORUS_FRUIT_POPPED -> ItemTypes.CHORUS_FRUIT_POPPED
            Material.BEETROOT -> ItemTypes.BEETROOT
            Material.BEETROOT_SEEDS -> ItemTypes.BEETROOT_SEEDS
            Material.BEETROOT_SOUP -> ItemTypes.BEETROOT_SOUP
            Material.DRAGONS_BREATH -> ItemTypes.DRAGON_BREATH
            Material.SPLASH_POTION -> ItemTypes.SPLASH_POTION
            Material.SPECTRAL_ARROW -> ItemTypes.SPECTRAL_ARROW
            Material.TIPPED_ARROW -> ItemTypes.TIPPED_ARROW
            Material.LINGERING_POTION -> ItemTypes.LINGERING_POTION
            Material.SHIELD -> ItemTypes.SHIELD
            Material.ELYTRA -> ItemTypes.ELYTRA
            Material.BOAT_SPRUCE -> ItemTypes.SPRUCE_BOAT
            Material.BOAT_BIRCH -> ItemTypes.BIRCH_BOAT
            Material.BOAT_JUNGLE -> ItemTypes.JUNGLE_BOAT
            Material.BOAT_ACACIA -> ItemTypes.ACACIA_BOAT
            Material.BOAT_DARK_OAK -> ItemTypes.DARK_OAK_BOAT
            Material.TOTEM -> ItemTypes.TOTEM_OF_UNDYING
            Material.SHULKER_SHELL -> ItemTypes.SHULKER_SHELL
            Material.IRON_NUGGET -> ItemTypes.IRON_NUGGET
            Material.KNOWLEDGE_BOOK -> ItemTypes.KNOWLEDGE_BOOK
            Material.GOLD_RECORD -> ItemTypes.RECORD_13
            Material.GREEN_RECORD -> ItemTypes.RECORD_CAT
            Material.RECORD_3 -> ItemTypes.RECORD_BLOCKS
            Material.RECORD_4 -> ItemTypes.RECORD_CHIRP
            Material.RECORD_5 -> ItemTypes.RECORD_FAR
            Material.RECORD_6 -> ItemTypes.RECORD_MALL
            Material.RECORD_7 -> ItemTypes.RECORD_MELLOHI
            Material.RECORD_8 -> ItemTypes.RECORD_STAL
            Material.RECORD_9 -> ItemTypes.RECORD_STRAD
            Material.RECORD_10 -> ItemTypes.RECORD_WARD
            Material.RECORD_11 -> ItemTypes.RECORD_11
            Material.RECORD_12 -> ItemTypes.RECORD_WAIT
            else -> throw IllegalArgumentException("not an item: $it")
        }
    })

fun Material.toItemType(): ItemType? = itemTypeMap[this]

fun ItemType.toMaterial(): Material = itemTypeMap.inverse()[this] ?: TODO("modded")

private val blockTypeMap: BiMap<Material, BlockType> =
    HashBiMap.create(Material.values().filter { it.isBlock }.associateWith {
        when (it) {
            Material.AIR -> BlockTypes.AIR
            Material.STONE -> BlockTypes.STONE
            Material.GRASS -> BlockTypes.GRASS
            Material.DIRT -> BlockTypes.DIRT
            Material.COBBLESTONE -> BlockTypes.COBBLESTONE
            Material.WOOD -> BlockTypes.PLANKS
            Material.SAPLING -> BlockTypes.SAPLING
            Material.BEDROCK -> BlockTypes.BEDROCK
            Material.WATER -> BlockTypes.FLOWING_WATER
            Material.STATIONARY_WATER -> BlockTypes.WATER
            Material.LAVA -> BlockTypes.FLOWING_LAVA
            Material.STATIONARY_LAVA -> BlockTypes.LAVA
            Material.SAND -> BlockTypes.SAND
            Material.GRAVEL -> BlockTypes.GRAVEL
            Material.GOLD_ORE -> BlockTypes.GOLD_ORE
            Material.IRON_ORE -> BlockTypes.IRON_ORE
            Material.COAL_ORE -> BlockTypes.COAL_ORE
            Material.LOG -> BlockTypes.LOG
            Material.LEAVES -> BlockTypes.LEAVES
            Material.SPONGE -> BlockTypes.SPONGE
            Material.GLASS -> BlockTypes.GLASS
            Material.LAPIS_ORE -> BlockTypes.LAPIS_ORE
            Material.LAPIS_BLOCK -> BlockTypes.LAPIS_BLOCK
            Material.DISPENSER -> BlockTypes.DISPENSER
            Material.SANDSTONE -> BlockTypes.SANDSTONE
            Material.NOTE_BLOCK -> BlockTypes.NOTEBLOCK
            Material.BED_BLOCK -> BlockTypes.BED
            Material.POWERED_RAIL -> BlockTypes.GOLDEN_RAIL
            Material.DETECTOR_RAIL -> BlockTypes.DETECTOR_RAIL
            Material.PISTON_STICKY_BASE -> BlockTypes.STICKY_PISTON
            Material.WEB -> BlockTypes.WEB
            Material.LONG_GRASS -> BlockTypes.TALLGRASS
            Material.DEAD_BUSH -> BlockTypes.DEADBUSH
            Material.PISTON_BASE -> BlockTypes.PISTON
            Material.PISTON_EXTENSION -> BlockTypes.PISTON_HEAD
            Material.WOOL -> BlockTypes.WOOL
            Material.PISTON_MOVING_PIECE -> BlockTypes.PISTON_EXTENSION
            Material.YELLOW_FLOWER -> BlockTypes.YELLOW_FLOWER
            Material.RED_ROSE -> BlockTypes.RED_FLOWER
            Material.BROWN_MUSHROOM -> BlockTypes.BROWN_MUSHROOM
            Material.RED_MUSHROOM -> BlockTypes.RED_MUSHROOM
            Material.GOLD_BLOCK -> BlockTypes.GOLD_BLOCK
            Material.IRON_BLOCK -> BlockTypes.IRON_BLOCK
            Material.DOUBLE_STEP -> BlockTypes.DOUBLE_STONE_SLAB
            Material.STEP -> BlockTypes.STONE_SLAB
            Material.BRICK -> BlockTypes.BRICK_BLOCK
            Material.TNT -> BlockTypes.TNT
            Material.BOOKSHELF -> BlockTypes.BOOKSHELF
            Material.MOSSY_COBBLESTONE -> BlockTypes.MOSSY_COBBLESTONE
            Material.OBSIDIAN -> BlockTypes.OBSIDIAN
            Material.TORCH -> BlockTypes.TORCH
            Material.FIRE -> BlockTypes.FIRE
            Material.MOB_SPAWNER -> BlockTypes.MOB_SPAWNER
            Material.WOOD_STAIRS -> BlockTypes.OAK_STAIRS
            Material.CHEST -> BlockTypes.CHEST
            Material.REDSTONE_WIRE -> BlockTypes.REDSTONE_WIRE
            Material.DIAMOND_ORE -> BlockTypes.DIAMOND_ORE
            Material.DIAMOND_BLOCK -> BlockTypes.DIAMOND_BLOCK
            Material.WORKBENCH -> BlockTypes.CRAFTING_TABLE
            Material.CROPS -> BlockTypes.WHEAT
            Material.SOIL -> BlockTypes.FARMLAND
            Material.FURNACE -> BlockTypes.FURNACE
            Material.BURNING_FURNACE -> BlockTypes.LIT_FURNACE
            Material.SIGN_POST -> BlockTypes.STANDING_SIGN
            Material.WOODEN_DOOR -> BlockTypes.WOODEN_DOOR
            Material.LADDER -> BlockTypes.LADDER
            Material.RAILS -> BlockTypes.RAIL
            Material.COBBLESTONE_STAIRS -> BlockTypes.STONE_STAIRS
            Material.WALL_SIGN -> BlockTypes.WALL_SIGN
            Material.LEVER -> BlockTypes.LEVER
            Material.STONE_PLATE -> BlockTypes.STONE_PRESSURE_PLATE
            Material.IRON_DOOR_BLOCK -> BlockTypes.IRON_DOOR
            Material.WOOD_PLATE -> BlockTypes.WOODEN_PRESSURE_PLATE
            Material.REDSTONE_ORE -> BlockTypes.REDSTONE_ORE
            Material.GLOWING_REDSTONE_ORE -> BlockTypes.LIT_REDSTONE_ORE
            Material.REDSTONE_TORCH_OFF -> BlockTypes.UNLIT_REDSTONE_TORCH
            Material.REDSTONE_TORCH_ON -> BlockTypes.REDSTONE_TORCH
            Material.STONE_BUTTON -> BlockTypes.STONE_BUTTON
            Material.SNOW -> BlockTypes.SNOW_LAYER
            Material.ICE -> BlockTypes.ICE
            Material.SNOW_BLOCK -> BlockTypes.SNOW
            Material.CACTUS -> BlockTypes.CACTUS
            Material.CLAY -> BlockTypes.CLAY
            Material.SUGAR_CANE_BLOCK -> BlockTypes.REEDS
            Material.JUKEBOX -> BlockTypes.JUKEBOX
            Material.FENCE -> BlockTypes.FENCE
            Material.PUMPKIN -> BlockTypes.PUMPKIN
            Material.NETHERRACK -> BlockTypes.NETHERRACK
            Material.SOUL_SAND -> BlockTypes.SOUL_SAND
            Material.GLOWSTONE -> BlockTypes.GLOWSTONE
            Material.PORTAL -> BlockTypes.PORTAL
            Material.JACK_O_LANTERN -> BlockTypes.LIT_PUMPKIN
            Material.CAKE_BLOCK -> BlockTypes.CAKE
            Material.DIODE_BLOCK_OFF -> BlockTypes.UNPOWERED_REPEATER
            Material.DIODE_BLOCK_ON -> BlockTypes.POWERED_REPEATER
            Material.STAINED_GLASS -> BlockTypes.STAINED_GLASS
            Material.TRAP_DOOR -> BlockTypes.TRAPDOOR
            Material.MONSTER_EGGS -> BlockTypes.MONSTER_EGG
            Material.SMOOTH_BRICK -> BlockTypes.STONEBRICK
            Material.HUGE_MUSHROOM_1 -> BlockTypes.BROWN_MUSHROOM_BLOCK
            Material.HUGE_MUSHROOM_2 -> BlockTypes.RED_MUSHROOM_BLOCK
            Material.IRON_FENCE -> BlockTypes.IRON_BARS
            Material.THIN_GLASS -> BlockTypes.GLASS_PANE
            Material.MELON_BLOCK -> BlockTypes.MELON_BLOCK
            Material.PUMPKIN_STEM -> BlockTypes.PUMPKIN_STEM
            Material.MELON_STEM -> BlockTypes.MELON_STEM
            Material.VINE -> BlockTypes.VINE
            Material.FENCE_GATE -> BlockTypes.FENCE_GATE
            Material.BRICK_STAIRS -> BlockTypes.BRICK_STAIRS
            Material.SMOOTH_STAIRS -> BlockTypes.STONE_BRICK_STAIRS
            Material.MYCEL -> BlockTypes.MYCELIUM
            Material.WATER_LILY -> BlockTypes.WATERLILY
            Material.NETHER_BRICK -> BlockTypes.NETHER_BRICK
            Material.NETHER_FENCE -> BlockTypes.NETHER_BRICK_FENCE
            Material.NETHER_BRICK_STAIRS -> BlockTypes.NETHER_BRICK_STAIRS
            Material.NETHER_WARTS -> BlockTypes.NETHER_WART
            Material.ENCHANTMENT_TABLE -> BlockTypes.ENCHANTING_TABLE
            Material.BREWING_STAND -> BlockTypes.BREWING_STAND
            Material.CAULDRON -> BlockTypes.CAULDRON
            Material.ENDER_PORTAL -> BlockTypes.END_PORTAL
            Material.ENDER_PORTAL_FRAME -> BlockTypes.END_PORTAL_FRAME
            Material.ENDER_STONE -> BlockTypes.END_STONE
            Material.DRAGON_EGG -> BlockTypes.DRAGON_EGG
            Material.REDSTONE_LAMP_OFF -> BlockTypes.REDSTONE_LAMP
            Material.REDSTONE_LAMP_ON -> BlockTypes.LIT_REDSTONE_LAMP
            Material.WOOD_DOUBLE_STEP -> BlockTypes.DOUBLE_WOODEN_SLAB
            Material.WOOD_STEP -> BlockTypes.WOODEN_SLAB
            Material.COCOA -> BlockTypes.COCOA
            Material.SANDSTONE_STAIRS -> BlockTypes.SANDSTONE_STAIRS
            Material.EMERALD_ORE -> BlockTypes.EMERALD_ORE
            Material.ENDER_CHEST -> BlockTypes.ENDER_CHEST
            Material.TRIPWIRE_HOOK -> BlockTypes.TRIPWIRE_HOOK
            Material.TRIPWIRE -> BlockTypes.TRIPWIRE
            Material.EMERALD_BLOCK -> BlockTypes.EMERALD_BLOCK
            Material.SPRUCE_WOOD_STAIRS -> BlockTypes.SPRUCE_STAIRS
            Material.BIRCH_WOOD_STAIRS -> BlockTypes.BIRCH_STAIRS
            Material.JUNGLE_WOOD_STAIRS -> BlockTypes.JUNGLE_STAIRS
            Material.COMMAND -> BlockTypes.COMMAND_BLOCK
            Material.BEACON -> BlockTypes.BEACON
            Material.COBBLE_WALL -> BlockTypes.COBBLESTONE_WALL
            Material.FLOWER_POT -> BlockTypes.FLOWER_POT
            Material.CARROT -> BlockTypes.CARROTS
            Material.POTATO -> BlockTypes.POTATOES
            Material.WOOD_BUTTON -> BlockTypes.WOODEN_BUTTON
            Material.SKULL -> BlockTypes.SKULL
            Material.ANVIL -> BlockTypes.ANVIL
            Material.TRAPPED_CHEST -> BlockTypes.TRAPPED_CHEST
            Material.GOLD_PLATE -> BlockTypes.LIGHT_WEIGHTED_PRESSURE_PLATE
            Material.IRON_PLATE -> BlockTypes.HEAVY_WEIGHTED_PRESSURE_PLATE
            Material.REDSTONE_COMPARATOR_OFF -> BlockTypes.UNPOWERED_COMPARATOR
            Material.REDSTONE_COMPARATOR_ON -> BlockTypes.POWERED_COMPARATOR
            Material.DAYLIGHT_DETECTOR -> BlockTypes.DAYLIGHT_DETECTOR
            Material.REDSTONE_BLOCK -> BlockTypes.REDSTONE_BLOCK
            Material.QUARTZ_ORE -> BlockTypes.QUARTZ_ORE
            Material.HOPPER -> BlockTypes.HOPPER
            Material.QUARTZ_BLOCK -> BlockTypes.QUARTZ_BLOCK
            Material.QUARTZ_STAIRS -> BlockTypes.QUARTZ_STAIRS
            Material.ACTIVATOR_RAIL -> BlockTypes.ACTIVATOR_RAIL
            Material.DROPPER -> BlockTypes.DROPPER
            Material.STAINED_CLAY -> BlockTypes.STAINED_HARDENED_CLAY
            Material.STAINED_GLASS_PANE -> BlockTypes.STAINED_GLASS_PANE
            Material.LEAVES_2 -> BlockTypes.LEAVES2
            Material.LOG_2 -> BlockTypes.LOG2
            Material.ACACIA_STAIRS -> BlockTypes.ACACIA_STAIRS
            Material.DARK_OAK_STAIRS -> BlockTypes.DARK_OAK_STAIRS
            Material.SLIME_BLOCK -> BlockTypes.SLIME
            Material.BARRIER -> BlockTypes.BARRIER
            Material.IRON_TRAPDOOR -> BlockTypes.IRON_TRAPDOOR
            Material.PRISMARINE -> BlockTypes.PRISMARINE
            Material.SEA_LANTERN -> BlockTypes.SEA_LANTERN
            Material.HAY_BLOCK -> BlockTypes.HAY_BLOCK
            Material.CARPET -> BlockTypes.CARPET
            Material.HARD_CLAY -> BlockTypes.HARDENED_CLAY
            Material.COAL_BLOCK -> BlockTypes.COAL_BLOCK
            Material.PACKED_ICE -> BlockTypes.PACKED_ICE
            Material.DOUBLE_PLANT -> BlockTypes.DOUBLE_PLANT
            Material.STANDING_BANNER -> BlockTypes.STANDING_BANNER
            Material.WALL_BANNER -> BlockTypes.WALL_BANNER
            Material.DAYLIGHT_DETECTOR_INVERTED -> BlockTypes.DAYLIGHT_DETECTOR_INVERTED
            Material.RED_SANDSTONE -> BlockTypes.RED_SANDSTONE
            Material.RED_SANDSTONE_STAIRS -> BlockTypes.RED_SANDSTONE_STAIRS
            Material.DOUBLE_STONE_SLAB2 -> BlockTypes.DOUBLE_STONE_SLAB2
            Material.STONE_SLAB2 -> BlockTypes.STONE_SLAB2
            Material.SPRUCE_FENCE_GATE -> BlockTypes.SPRUCE_FENCE_GATE
            Material.BIRCH_FENCE_GATE -> BlockTypes.BIRCH_FENCE_GATE
            Material.JUNGLE_FENCE_GATE -> BlockTypes.JUNGLE_FENCE_GATE
            Material.DARK_OAK_FENCE_GATE -> BlockTypes.DARK_OAK_FENCE_GATE
            Material.ACACIA_FENCE_GATE -> BlockTypes.ACACIA_FENCE_GATE
            Material.SPRUCE_FENCE -> BlockTypes.SPRUCE_FENCE
            Material.BIRCH_FENCE -> BlockTypes.BIRCH_FENCE
            Material.JUNGLE_FENCE -> BlockTypes.JUNGLE_FENCE
            Material.DARK_OAK_FENCE -> BlockTypes.DARK_OAK_FENCE
            Material.ACACIA_FENCE -> BlockTypes.ACACIA_FENCE
            Material.SPRUCE_DOOR -> BlockTypes.SPRUCE_DOOR
            Material.BIRCH_DOOR -> BlockTypes.BIRCH_DOOR
            Material.JUNGLE_DOOR -> BlockTypes.JUNGLE_DOOR
            Material.ACACIA_DOOR -> BlockTypes.ACACIA_DOOR
            Material.DARK_OAK_DOOR -> BlockTypes.DARK_OAK_DOOR
            Material.END_ROD -> BlockTypes.END_ROD
            Material.CHORUS_PLANT -> BlockTypes.CHORUS_PLANT
            Material.CHORUS_FLOWER -> BlockTypes.CHORUS_FLOWER
            Material.PURPUR_BLOCK -> BlockTypes.PURPUR_BLOCK
            Material.PURPUR_PILLAR -> BlockTypes.PURPUR_PILLAR
            Material.PURPUR_STAIRS -> BlockTypes.PURPUR_STAIRS
            Material.PURPUR_DOUBLE_SLAB -> BlockTypes.PURPUR_DOUBLE_SLAB
            Material.PURPUR_SLAB -> BlockTypes.PURPUR_SLAB
            Material.END_BRICKS -> BlockTypes.END_BRICKS
            Material.BEETROOT_BLOCK -> BlockTypes.BEETROOTS
            Material.GRASS_PATH -> BlockTypes.GRASS_PATH
            Material.END_GATEWAY -> BlockTypes.END_GATEWAY
            Material.COMMAND_REPEATING -> BlockTypes.REPEATING_COMMAND_BLOCK
            Material.COMMAND_CHAIN -> BlockTypes.CHAIN_COMMAND_BLOCK
            Material.FROSTED_ICE -> BlockTypes.FROSTED_ICE
            Material.MAGMA -> BlockTypes.MAGMA
            Material.NETHER_WART_BLOCK -> BlockTypes.NETHER_WART_BLOCK
            Material.RED_NETHER_BRICK -> BlockTypes.RED_NETHER_BRICK
            Material.BONE_BLOCK -> BlockTypes.BONE_BLOCK
            Material.STRUCTURE_VOID -> BlockTypes.STRUCTURE_VOID
            Material.OBSERVER -> BlockTypes.OBSERVER
            Material.WHITE_SHULKER_BOX -> BlockTypes.WHITE_SHULKER_BOX
            Material.ORANGE_SHULKER_BOX -> BlockTypes.ORANGE_SHULKER_BOX
            Material.MAGENTA_SHULKER_BOX -> BlockTypes.MAGENTA_SHULKER_BOX
            Material.LIGHT_BLUE_SHULKER_BOX -> BlockTypes.LIGHT_BLUE_SHULKER_BOX
            Material.YELLOW_SHULKER_BOX -> BlockTypes.YELLOW_SHULKER_BOX
            Material.LIME_SHULKER_BOX -> BlockTypes.LIME_SHULKER_BOX
            Material.PINK_SHULKER_BOX -> BlockTypes.PINK_SHULKER_BOX
            Material.GRAY_SHULKER_BOX -> BlockTypes.GRAY_SHULKER_BOX
            Material.SILVER_SHULKER_BOX -> BlockTypes.SILVER_SHULKER_BOX
            Material.CYAN_SHULKER_BOX -> BlockTypes.CYAN_SHULKER_BOX
            Material.PURPLE_SHULKER_BOX -> BlockTypes.PURPLE_SHULKER_BOX
            Material.BLUE_SHULKER_BOX -> BlockTypes.BLUE_SHULKER_BOX
            Material.BROWN_SHULKER_BOX -> BlockTypes.BROWN_SHULKER_BOX
            Material.GREEN_SHULKER_BOX -> BlockTypes.GREEN_SHULKER_BOX
            Material.RED_SHULKER_BOX -> BlockTypes.RED_SHULKER_BOX
            Material.BLACK_SHULKER_BOX -> BlockTypes.BLACK_SHULKER_BOX
            Material.WHITE_GLAZED_TERRACOTTA -> BlockTypes.WHITE_GLAZED_TERRACOTTA
            Material.ORANGE_GLAZED_TERRACOTTA -> BlockTypes.ORANGE_GLAZED_TERRACOTTA
            Material.MAGENTA_GLAZED_TERRACOTTA -> BlockTypes.MAGENTA_GLAZED_TERRACOTTA
            Material.LIGHT_BLUE_GLAZED_TERRACOTTA -> BlockTypes.LIGHT_BLUE_GLAZED_TERRACOTTA
            Material.YELLOW_GLAZED_TERRACOTTA -> BlockTypes.YELLOW_GLAZED_TERRACOTTA
            Material.LIME_GLAZED_TERRACOTTA -> BlockTypes.LIME_GLAZED_TERRACOTTA
            Material.PINK_GLAZED_TERRACOTTA -> BlockTypes.PINK_GLAZED_TERRACOTTA
            Material.GRAY_GLAZED_TERRACOTTA -> BlockTypes.GRAY_GLAZED_TERRACOTTA
            Material.SILVER_GLAZED_TERRACOTTA -> BlockTypes.SILVER_GLAZED_TERRACOTTA
            Material.CYAN_GLAZED_TERRACOTTA -> BlockTypes.CYAN_GLAZED_TERRACOTTA
            Material.PURPLE_GLAZED_TERRACOTTA -> BlockTypes.PURPLE_GLAZED_TERRACOTTA
            Material.BLUE_GLAZED_TERRACOTTA -> BlockTypes.BLUE_GLAZED_TERRACOTTA
            Material.BROWN_GLAZED_TERRACOTTA -> BlockTypes.BROWN_GLAZED_TERRACOTTA
            Material.GREEN_GLAZED_TERRACOTTA -> BlockTypes.GREEN_GLAZED_TERRACOTTA
            Material.RED_GLAZED_TERRACOTTA -> BlockTypes.RED_GLAZED_TERRACOTTA
            Material.BLACK_GLAZED_TERRACOTTA -> BlockTypes.BLACK_GLAZED_TERRACOTTA
            Material.CONCRETE -> BlockTypes.CONCRETE
            Material.CONCRETE_POWDER -> BlockTypes.CONCRETE_POWDER
            Material.STRUCTURE_BLOCK -> BlockTypes.STRUCTURE_BLOCK
            else -> throw IllegalArgumentException("not a block: $it")
        }
    })

fun Material.toBlockType(): BlockType? = blockTypeMap[this]

fun BlockType.toMaterial(): Material = blockTypeMap.inverse()[this] ?: TODO("modded")
