package flavor.pie.sunkcost.block

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.block.Biome
import org.spongepowered.api.world.biome.BiomeType
import org.spongepowered.api.world.biome.BiomeTypes

private val biomeTypeMap: BiMap<Biome, BiomeType> = HashBiMap.create(Biome.values().associate {
    it to when (it) {
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
        Biome.REDWOOD_TAIGA -> BiomeTypes.MEGA_TAIGA
        Biome.REDWOOD_TAIGA_HILLS -> BiomeTypes.MEGA_TAIGA_HILLS
        Biome.EXTREME_HILLS_WITH_TREES -> BiomeTypes.EXTREME_HILLS_PLUS
        Biome.SAVANNA -> BiomeTypes.SAVANNA
        Biome.SAVANNA_ROCK -> BiomeTypes.SAVANNA_PLATEAU
        Biome.MESA -> BiomeTypes.MESA
        Biome.MESA_ROCK -> BiomeTypes.MESA_PLATEAU
        Biome.MESA_CLEAR_ROCK -> BiomeTypes.MESA_PLATEAU_FOREST
        Biome.VOID -> BiomeTypes.VOID
        Biome.MUTATED_PLAINS -> BiomeTypes.SUNFLOWER_PLAINS
        Biome.MUTATED_DESERT -> BiomeTypes.DESERT_MOUNTAINS
        Biome.MUTATED_EXTREME_HILLS -> BiomeTypes.EXTREME_HILLS_MOUNTAINS
        Biome.MUTATED_FOREST -> BiomeTypes.FLOWER_FOREST
        Biome.MUTATED_TAIGA -> BiomeTypes.TAIGA_MOUNTAINS
        Biome.MUTATED_SWAMPLAND -> BiomeTypes.SWAMPLAND
        Biome.MUTATED_ICE_FLATS -> BiomeTypes.ICE_PLAINS_SPIKES
        Biome.MUTATED_JUNGLE -> BiomeTypes.JUNGLE_MOUNTAINS
        Biome.MUTATED_JUNGLE_EDGE -> BiomeTypes.JUNGLE_EDGE_MOUNTAINS
        Biome.MUTATED_BIRCH_FOREST -> BiomeTypes.BIRCH_FOREST_MOUNTAINS
        Biome.MUTATED_BIRCH_FOREST_HILLS -> BiomeTypes.BIRCH_FOREST_HILLS_MOUNTAINS
        Biome.MUTATED_ROOFED_FOREST -> BiomeTypes.ROOFED_FOREST_MOUNTAINS
        Biome.MUTATED_TAIGA_COLD -> BiomeTypes.COLD_TAIGA_MOUNTAINS
        Biome.MUTATED_REDWOOD_TAIGA -> BiomeTypes.MEGA_SPRUCE_TAIGA
        Biome.MUTATED_REDWOOD_TAIGA_HILLS -> BiomeTypes.MEGA_SPRUCE_TAIGA_HILLS
        Biome.MUTATED_EXTREME_HILLS_WITH_TREES -> BiomeTypes.EXTREME_HILLS_PLUS_MOUNTAINS
        Biome.MUTATED_SAVANNA -> BiomeTypes.SAVANNA_MOUNTAINS
        Biome.MUTATED_SAVANNA_ROCK -> BiomeTypes.SAVANNA_PLATEAU_MOUNTAINS
        Biome.MUTATED_MESA -> BiomeTypes.MESA_BRYCE
        Biome.MUTATED_MESA_ROCK -> BiomeTypes.MESA_PLATEAU_MOUNTAINS
        Biome.MUTATED_MESA_CLEAR_ROCK -> BiomeTypes.MESA_PLATEAU_FOREST_MOUNTAINS
    }
})

fun Biome.biomeType(): BiomeType = biomeTypeMap.getValue(this)

fun BiomeType.biome(): Biome = biomeTypeMap.inverse()[this] ?: TODO("modded")
