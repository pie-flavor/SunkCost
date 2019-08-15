package flavor.pie.sunkcost

import com.flowpowered.math.vector.Vector3i
import flavor.pie.sunkcost.block.SunkBlockState
import flavor.pie.sunkcost.entity.SunkEntity
import org.bukkit.Chunk
import org.bukkit.ChunkSnapshot
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.entity.Entity
import org.spongepowered.api.world.Chunk as SChunk

class SunkChunk(val chunk: SChunk) : Chunk {

    override fun getX(): Int = chunk.position.x

    override fun getZ(): Int = chunk.position.z

    override fun isSlimeChunk(): Boolean {
        TODO("not implemented")
    }

    override fun getEntities(): Array<Entity> = chunk.entities.map { SunkEntity(it) }.toTypedArray()

    override fun getTileEntities(): Array<BlockState> =
        chunk.tileEntities.map { SunkBlockState(it.location.createSnapshot(), it.location) }.toTypedArray()

    override fun isLoaded(): Boolean = chunk.isLoaded

    override fun getChunkSnapshot(): ChunkSnapshot = SunkChunkSnapshot(
        chunk.createArchetypeVolume(chunk.blockMin, chunk.blockMax, Vector3i.ZERO),
        chunk.position,
        chunk.biomeCopy,
        chunk.world.name,
        chunk.world.properties.worldTime
    )

    override fun getChunkSnapshot(
        includeMaxblocky: Boolean,
        includeBiome: Boolean,
        includeBiomeTempRain: Boolean
    ): ChunkSnapshot = chunkSnapshot //todo refine

    override fun unload(save: Boolean, safe: Boolean): Boolean = unload() // deficiency

    override fun unload(save: Boolean): Boolean = unload() // deficiency

    override fun unload(): Boolean = chunk.unloadChunk()

    override fun getWorld(): World = SunkWorld(chunk.world)

    override fun getBlock(x: Int, y: Int, z: Int): Block = world.getBlockAt(x, y, z)

    override fun load(generate: Boolean): Boolean = chunk.loadChunk(generate)

    override fun load(): Boolean = load(true)

    override fun equals(other: Any?): Boolean = other is SunkChunk && chunk == other.chunk

    override fun hashCode(): Int = chunk.hashCode()

}
