package flavor.pie.sunkcost

import com.flowpowered.math.vector.Vector3i
import flavor.pie.sunkcost.block.biome
import flavor.pie.sunkcost.material.toMaterialData
import org.bukkit.ChunkSnapshot
import org.bukkit.Material
import org.bukkit.block.Biome
import org.spongepowered.api.block.BlockTypes
import org.spongepowered.api.world.extent.ArchetypeVolume
import org.spongepowered.api.world.extent.BiomeVolume

class SunkChunkSnapshot(
    val volume: ArchetypeVolume,
    val pos: Vector3i,
    val biomes: BiomeVolume,
    val name: String,
    val time: Long
) : ChunkSnapshot {
    override fun getBlockSkyLight(x: Int, y: Int, z: Int): Int {
        TODO("not implemented")
    }

    override fun getX(): Int = pos.x

    override fun getZ(): Int = pos.z

    override fun getRawBiomeTemperature(x: Int, z: Int): Double = biomes.getBiome(x, biomes.biomeMin.y, z).temperature

    override fun getWorldName(): String = name

    override fun getHighestBlockYAt(x: Int, z: Int): Int {
        val maxY = volume.blockMax.y
        val minY = volume.blockMin.y
        for (i in (minY..maxY).reversed()) {
            if (volume.getBlockType(x, i, z) != BlockTypes.AIR) {
                return i
            }
        }
        return 0
    }

    @Suppress("DEPRECATION")
    override fun getBlockTypeId(x: Int, y: Int, z: Int): Int = volume.getBlockType(x, y, z).toMaterial().id

    override fun isSectionEmpty(sy: Int): Boolean {
        TODO("not implemented")
    }

    @Suppress("DEPRECATION")
    override fun getBlockData(x: Int, y: Int, z: Int): Int = volume.getBlock(x, y, z).toMaterialData().data.toInt()

    override fun getBlockEmittedLight(x: Int, y: Int, z: Int): Int {
        TODO("not implemented")
    }

    override fun getRawBiomeRainfall(x: Int, z: Int): Double = biomes.getBiome(x, biomes.biomeMin.y, z).humidity

    override fun getBlockType(x: Int, y: Int, z: Int): Material = volume.getBlockType(x, y, z).toMaterial()

    override fun getBiome(x: Int, z: Int): Biome = biomes.getBiome(x, biomes.biomeMin.y, z).biome()

    override fun getCaptureFullTime(): Long = time

}