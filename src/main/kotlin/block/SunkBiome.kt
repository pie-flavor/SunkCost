package flavor.pie.sunkcost.block

import org.bukkit.block.Biome
import org.spongepowered.api.world.biome.BiomeType
import org.spongepowered.api.world.biome.BiomeTypes

fun Biome.biomeType(): BiomeType = when (this) {
    Biome.OCEAN -> BiomeTypes.OCEAN
    Biome.PLAINS -> BiomeTypes.PLAINS
    Biome.DESERT -> BiomeTypes.DESERT
    Biome.EXTREME_HILLS -> BiomeTypes.EXTREME_HILLS
    Biome.FOREST -> BiomeTypes.FOREST
    Biome.TAIGA -> BiomeTypes.TAIGA
    Biome.SWAMPLAND -> BiomeTypes.SWAMPLAND
    Biome.RIVER -> BiomeTypes.RIVER
    Biome.HELL -> BiomeTypes.HELL
    Biome.SKY -> BiomeTypes.SKY
    Biome.FROZEN_OCEAN -> BiomeTypes.FROZEN_OCEAN
    Biome.FROZEN_RIVER -> BiomeTypes.FROZEN_RIVER
    Biome.ICE_FLATS -> BiomeTypes.ICE_PLAINS
    Biome.ICE_MOUNTAINS -> BiomeTypes.ICE_MOUNTAINS
    Biome.MUSHROOM_ISLAND -> BiomeTypes.MUSHROOM_ISLAND
    Biome.MUSHROOM_ISLAND_SHORE -> BiomeTypes.MUSHROOM_ISLAND_SHORE
    Biome.BEACHES -> BiomeTypes.BEACH
    Biome.DESERT_HILLS -> BiomeTypes.DESERT_HILLS
    Biome.FOREST_HILLS -> BiomeTypes.FOREST_HILLS
    Biome.TAIGA_HILLS -> BiomeTypes.TAIGA_HILLS
    Biome.SMALLER_EXTREME_HILLS -> BiomeTypes.EXTREME_HILLS_EDGE
    Biome.JUNGLE -> BiomeTypes.JUNGLE
    Biome.JUNGLE_HILLS -> BiomeTypes.JUNGLE_HILLS
    Biome.JUNGLE_EDGE -> BiomeTypes.JUNGLE_EDGE
    Biome.DEEP_OCEAN -> BiomeTypes.DEEP_OCEAN
    Biome.STONE_BEACH -> BiomeTypes.STONE_BEACH
    Biome.COLD_BEACH -> BiomeTypes.COLD_BEACH
    Biome.BIRCH_FOREST -> BiomeTypes.BIRCH_FOREST
    Biome.BIRCH_FOREST_HILLS -> BiomeTypes.BIRCH_FOREST_HILLS
    Biome.ROOFED_FOREST -> BiomeTypes.ROOFED_FOREST
    Biome.TAIGA_COLD -> BiomeTypes.COLD_TAIGA
    Biome.TAIGA_COLD_HILLS -> BiomeTypes.COLD_TAIGA_HILLS
    Biome.REDWOOD_TAIGA -> BiomeTypes.MEGA_SPRUCE_TAIGA
    Biome.REDWOOD_TAIGA_HILLS -> BiomeTypes.MEGA_SPRUCE_TAIGA_HILLS
    Biome.EXTREME_HILLS_WITH_TREES -> BiomeTypes.EXTREME_HILLS_PLUS
    Biome.SAVANNA -> BiomeTypes.SAVANNA
    Biome.SAVANNA_ROCK -> BiomeTypes.SAVANNA_MOUNTAINS
    Biome.MESA -> BiomeTypes.MESA
    Biome.MESA_ROCK -> BiomeTypes.MESA_BRYCE
    Biome.MESA_CLEAR_ROCK -> BiomeTypes.MESA_BRYCE
    Biome.VOID -> BiomeTypes.VOID
    //api does not support mutated
    Biome.MUTATED_PLAINS -> BiomeTypes.PLAINS
    Biome.MUTATED_DESERT -> BiomeTypes.DESERT
    Biome.MUTATED_EXTREME_HILLS -> BiomeTypes.EXTREME_HILLS
    Biome.MUTATED_FOREST -> BiomeTypes.FOREST
    Biome.MUTATED_TAIGA -> BiomeTypes.TAIGA
    Biome.MUTATED_SWAMPLAND -> BiomeTypes.SWAMPLAND
    Biome.MUTATED_ICE_FLATS -> BiomeTypes.ICE_PLAINS
    Biome.MUTATED_JUNGLE -> BiomeTypes.JUNGLE
    Biome.MUTATED_JUNGLE_EDGE -> BiomeTypes.JUNGLE_EDGE
    Biome.MUTATED_BIRCH_FOREST -> BiomeTypes.BIRCH_FOREST
    Biome.MUTATED_BIRCH_FOREST_HILLS -> BiomeTypes.BIRCH_FOREST_HILLS
    Biome.MUTATED_ROOFED_FOREST -> BiomeTypes.ROOFED_FOREST
    Biome.MUTATED_TAIGA_COLD -> BiomeTypes.COLD_TAIGA
    Biome.MUTATED_REDWOOD_TAIGA -> BiomeTypes.MEGA_SPRUCE_TAIGA
    Biome.MUTATED_REDWOOD_TAIGA_HILLS -> BiomeTypes.MEGA_SPRUCE_TAIGA_HILLS
    Biome.MUTATED_EXTREME_HILLS_WITH_TREES -> BiomeTypes.EXTREME_HILLS_PLUS
    Biome.MUTATED_SAVANNA -> BiomeTypes.SAVANNA
    Biome.MUTATED_SAVANNA_ROCK -> BiomeTypes.SAVANNA_PLATEAU
    Biome.MUTATED_MESA -> BiomeTypes.MESA
    Biome.MUTATED_MESA_ROCK -> BiomeTypes.MESA_BRYCE
    Biome.MUTATED_MESA_CLEAR_ROCK -> BiomeTypes.MESA_BRYCE
}

fun BiomeType.biome(): Biome = when (this) {
    BiomeTypes.OCEAN -> Biome.OCEAN
    BiomeTypes.PLAINS -> Biome.PLAINS
    BiomeTypes.DESERT -> Biome.DESERT
    BiomeTypes.EXTREME_HILLS -> Biome.EXTREME_HILLS
    BiomeTypes.FOREST -> Biome.FOREST
    BiomeTypes.TAIGA -> Biome.TAIGA
    BiomeTypes.SWAMPLAND -> Biome.SWAMPLAND
    BiomeTypes.RIVER -> Biome.RIVER
    BiomeTypes.HELL -> Biome.HELL
    BiomeTypes.SKY -> Biome.SKY
    BiomeTypes.FROZEN_OCEAN -> Biome.FROZEN_OCEAN
    BiomeTypes.FROZEN_RIVER -> Biome.FROZEN_RIVER
    BiomeTypes.ICE_PLAINS -> Biome.ICE_FLATS
    BiomeTypes.ICE_MOUNTAINS -> Biome.ICE_MOUNTAINS
    BiomeTypes.MUSHROOM_ISLAND -> Biome.MUSHROOM_ISLAND
    BiomeTypes.MUSHROOM_ISLAND_SHORE -> Biome.MUSHROOM_ISLAND_SHORE
    BiomeTypes.BEACH -> Biome.BEACHES
    BiomeTypes.DESERT_HILLS -> Biome.DESERT_HILLS
    BiomeTypes.FOREST_HILLS -> Biome.FOREST_HILLS
    BiomeTypes.TAIGA_HILLS -> Biome.TAIGA_HILLS
    BiomeTypes.EXTREME_HILLS_EDGE -> Biome.SMALLER_EXTREME_HILLS
    BiomeTypes.JUNGLE -> Biome.JUNGLE
    BiomeTypes.JUNGLE_HILLS -> Biome.JUNGLE_HILLS
    BiomeTypes.JUNGLE_EDGE -> Biome.JUNGLE_EDGE
    BiomeTypes.DEEP_OCEAN -> Biome.DEEP_OCEAN
    BiomeTypes.STONE_BEACH -> Biome.STONE_BEACH
    BiomeTypes.COLD_BEACH -> Biome.COLD_BEACH
    BiomeTypes.BIRCH_FOREST -> Biome.BIRCH_FOREST
    BiomeTypes.BIRCH_FOREST_HILLS -> Biome.BIRCH_FOREST_HILLS
    BiomeTypes.ROOFED_FOREST -> Biome.ROOFED_FOREST
    BiomeTypes.COLD_TAIGA -> Biome.TAIGA_COLD
    BiomeTypes.COLD_TAIGA_HILLS -> Biome.TAIGA_COLD_HILLS
    BiomeTypes.MEGA_SPRUCE_TAIGA -> Biome.REDWOOD_TAIGA
    BiomeTypes.MEGA_SPRUCE_TAIGA_HILLS -> Biome.REDWOOD_TAIGA_HILLS
    BiomeTypes.EXTREME_HILLS_PLUS -> Biome.EXTREME_HILLS_WITH_TREES
    BiomeTypes.SAVANNA -> Biome.SAVANNA
    BiomeTypes.SAVANNA_MOUNTAINS -> Biome.SAVANNA_ROCK
    BiomeTypes.MESA -> Biome.MESA
    BiomeTypes.MESA_BRYCE -> Biome.MESA_ROCK
    BiomeTypes.VOID -> Biome.VOID
    else -> Biome.VOID //todo modded
}