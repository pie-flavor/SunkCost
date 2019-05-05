package flavor.pie.sunkcost

import org.bukkit.Chunk
import org.bukkit.ChunkSnapshot
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.entity.Entity
import org.spongepowered.api.world.Chunk as SChunk

class SunkChunk(val chunk: SChunk) : Chunk {

    override fun getX(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getZ(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSlimeChunk(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEntities(): Array<Entity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTileEntities(): Array<BlockState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isLoaded(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChunkSnapshot(): ChunkSnapshot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChunkSnapshot(
        includeMaxblocky: Boolean,
        includeBiome: Boolean,
        includeBiomeTempRain: Boolean
    ): ChunkSnapshot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unload(save: Boolean, safe: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unload(save: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unload(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorld(): World {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBlock(x: Int, y: Int, z: Int): Block {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun load(generate: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun load(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}