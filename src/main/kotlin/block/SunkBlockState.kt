package flavor.pie.sunkcost.block

import flavor.pie.sunkcost.bLocation
import flavor.pie.sunkcost.material.toBlockState
import flavor.pie.sunkcost.material.toMaterialData
import flavor.pie.sunkcost.metadata.SunkProxyMetadatable
import flavor.pie.sunkcost.toBlock
import flavor.pie.sunkcost.toBlockType
import flavor.pie.sunkcost.toMaterial
import org.bukkit.Chunk
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.material.MaterialData
import org.bukkit.metadata.Metadatable
import org.spongepowered.api.block.BlockSnapshot
import org.spongepowered.api.world.BlockChangeFlags
import org.spongepowered.api.world.Location as SLocation
import org.spongepowered.api.world.World as SWorld

@Suppress("DEPRECATION")
class SunkBlockState(var snapshot: BlockSnapshot, val loc: SLocation<SWorld>?) : BlockState, Metadatable by SunkProxyMetadatable(snapshot) {
    override fun getLightLevel(): Byte {
        TODO("not implemented")
    }

    override fun setRawData(data: Byte) {
        val mdata = snapshot.state.toMaterialData()
        mdata.data = data
        snapshot = snapshot.withState(mdata.toBlockState() ?: throw IllegalArgumentException("data"))
    }

    override fun setType(type: Material) {
        snapshot = snapshot.withState(type.toBlockType()?.defaultState ?: throw IllegalArgumentException("type"))
    }

    override fun getTypeId(): Int = snapshot.state.type.toMaterial().id

    override fun getY(): Int = loc?.blockY ?: 0

    override fun setTypeId(type: Int): Boolean {
        snapshot = snapshot.withState(Material.getMaterial(type)?.toBlockType()?.defaultState ?: return false)
        return true
    }

    override fun setData(data: MaterialData) {
        snapshot = snapshot.withState(data.toBlockState() ?: throw IllegalArgumentException("data"))
    }

    override fun update(): Boolean = update(force = false, applyPhysics = true)

    override fun update(force: Boolean): Boolean = update(force, applyPhysics = true)

    override fun update(force: Boolean, applyPhysics: Boolean): Boolean =
        snapshot.restore(force, if (applyPhysics) { BlockChangeFlags.ALL } else { BlockChangeFlags.NONE })

    override fun getWorld(): World = location.world

    override fun getRawData(): Byte = data.data

    override fun getChunk(): Chunk = world.getChunkAt(location)

    override fun getLocation(): Location = loc?.bLocation() ?: Location(null, x.toDouble(), y.toDouble(), z.toDouble())

    override fun getLocation(loc: Location?): Location? {
        if (loc == null) {
            return null
        }
        loc.x = x.toDouble()
        loc.y = y.toDouble()
        loc.z = z.toDouble()
        return loc
    }

    override fun getX(): Int = loc?.blockZ ?: 0

    override fun isPlaced(): Boolean = loc != null

    override fun getZ(): Int = loc?.blockZ ?: 0

    override fun getType(): Material = snapshot.state.type.toMaterial()

    override fun getData(): MaterialData = snapshot.state.toMaterialData()

    override fun getBlock(): Block = loc?.toBlock() ?: throw IllegalStateException()
}
