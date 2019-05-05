package flavor.pie.sunkcost.block

import com.flowpowered.math.vector.Vector3i
import flavor.pie.kludge.*
import flavor.pie.sunkcost.SunkChunk
import flavor.pie.sunkcost.SunkWorld
import flavor.pie.sunkcost.bLocation
import flavor.pie.sunkcost.material.toBlockState
import flavor.pie.sunkcost.material.toMaterialData
import flavor.pie.sunkcost.metadata.SunkProxyMetadatable
import flavor.pie.sunkcost.toBlockType
import flavor.pie.sunkcost.toMaterial
import org.bukkit.Chunk
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.BlockState
import org.bukkit.block.PistonMoveReaction
import org.bukkit.inventory.ItemStack
import org.bukkit.metadata.Metadatable
import org.jetbrains.annotations.Contract
import org.spongepowered.api.block.BlockTypes
import org.spongepowered.api.world.BlockChangeFlags
import org.spongepowered.api.world.Location as SLocation
import org.spongepowered.api.world.World as SWorld

class SunkBlock(val location: SLocation<SWorld>) : Block, Metadatable by SunkProxyMetadatable(location) {

    override fun getLightFromSky(): Byte {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLightLevel(): Byte {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setType(type: Material) {
        type.toBlockType()?.let { location.setBlockType(it) }
    }

    override fun setType(type: Material, applyPhysics: Boolean) {
        type.toBlockType()?.let { location.setBlockType(it, if (applyPhysics) { BlockChangeFlags.NONE } else { BlockChangeFlags.ALL }) }
    }

    override fun getRelative(modX: Int, modY: Int, modZ: Int): Block = SunkBlock(location.add(Vector3i(modX, modY, modZ)))

    override fun getRelative(face: BlockFace): Block = SunkBlock(location.getRelative(face.toDirection()))

    override fun getRelative(face: BlockFace, distance: Int): Block =
        SunkBlock(location.add(face.toDirection().asBlockOffset() * distance))

    override fun getTypeId(): Int = location.blockType.toMaterial().id

    override fun getY(): Int = location.blockY

    override fun getPistonMoveReaction(): PistonMoveReaction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTypeId(type: Int): Boolean {
        val blocktype = Material.getMaterial(type)?.toBlockType() ?: return false
        return location.setBlockType(blocktype)
    }

    override fun setTypeId(type: Int, applyPhysics: Boolean): Boolean {
        val blocktype = Material.getMaterial(type)?.toBlockType() ?: return false
        return location.setBlockType(blocktype, if (applyPhysics) { BlockChangeFlags.ALL } else { BlockChangeFlags.NONE })
    }

    override fun setData(data: Byte) {
        val mdata = location.block.toMaterialData()
        mdata.data = data
        val state = mdata.toBlockState() ?: return
        location.block = state
    }

    override fun setData(data: Byte, applyPhysics: Boolean) {
        val mdata = location.block.toMaterialData()
        mdata.data = data
        val state = mdata.toBlockState() ?: return
        location.setBlock(state, if (applyPhysics) { BlockChangeFlags.ALL } else { BlockChangeFlags.NONE })
    }

    override fun setTypeIdAndData(type: Int, data: Byte, applyPhysics: Boolean): Boolean {
        val state = Material.getMaterial(type)?.getNewData(data)?.toBlockState() ?: return false
        return location.setBlock(state, if (applyPhysics) { BlockChangeFlags.ALL } else { BlockChangeFlags.NONE })
    }

    override fun isLiquid(): Boolean = location.blockType.let { it == BlockTypes.WATER || it == BlockTypes.LAVA || it == BlockTypes.FLOWING_LAVA || it == BlockTypes.FLOWING_WATER } //todo modded

    override fun breakNaturally(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun breakNaturally(tool: ItemStack?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBiome(): Biome = location.biome.biome()

    override fun getTemperature(): Double = location.biome.temperature

    override fun getWorld(): World = SunkWorld(location.extent)

    override fun getChunk(): Chunk? =
        location.extent.getChunkAtBlock(location.blockPosition).unwrap()?.let { SunkChunk(it) }

    override fun getLightFromBlocks(): Byte {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getState(): BlockState {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBiome(bio: Biome) {
        location.extent.setBiome(location.blockPosition, bio.biomeType())
    }

    override fun getBlockPower(face: BlockFace?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBlockPower(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocation(): Location = location.bLocation()

    @Contract("null -> null; !null -> new")
    override fun getLocation(loc: Location?): Location? {
        if (loc == null) {
            return null
        }
        val loc2 = location.bLocation()
        loc.x = loc2.x
        loc.y = loc2.y
        loc.z = loc2.z
        loc.pitch = loc2.pitch
        loc.yaw = loc2.yaw
        loc.world = loc2.world
        return loc2
    }

    override fun getDrops(): MutableCollection<ItemStack> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDrops(tool: ItemStack?): MutableCollection<ItemStack> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getX(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFace(block: Block?): BlockFace {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean = location.blockType == BlockTypes.AIR

    override fun getZ(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isBlockFaceIndirectlyPowered(face: BlockFace?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(): Material = location.blockType.toMaterial()

    override fun getData(): Byte = location.block.toMaterialData().data

    override fun isBlockFacePowered(face: BlockFace?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isBlockIndirectlyPowered(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isBlockPowered(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHumidity(): Double = location.biome.humidity
}