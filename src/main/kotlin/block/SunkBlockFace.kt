package flavor.pie.sunkcost.block

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.block.BlockFace
import org.spongepowered.api.util.Direction

private val blockFaceMap: BiMap<BlockFace, Direction> = HashBiMap.create(BlockFace.values().associate {
    it to when (it) {
        BlockFace.DOWN -> Direction.DOWN
        BlockFace.EAST -> Direction.EAST
        BlockFace.EAST_NORTH_EAST -> Direction.EAST_NORTHEAST
        BlockFace.EAST_SOUTH_EAST -> Direction.EAST_SOUTHEAST
        BlockFace.NORTH -> Direction.NORTH
        BlockFace.NORTH_EAST -> Direction.NORTHEAST
        BlockFace.NORTH_NORTH_EAST -> Direction.NORTH_NORTHEAST
        BlockFace.NORTH_NORTH_WEST -> Direction.NORTH_NORTHWEST
        BlockFace.NORTH_WEST -> Direction.NORTHWEST
        BlockFace.SELF -> Direction.NONE
        BlockFace.SOUTH -> Direction.SOUTH
        BlockFace.SOUTH_EAST -> Direction.SOUTHEAST
        BlockFace.SOUTH_SOUTH_EAST -> Direction.SOUTH_SOUTHEAST
        BlockFace.SOUTH_SOUTH_WEST -> Direction.SOUTH_SOUTHWEST
        BlockFace.SOUTH_WEST -> Direction.SOUTHWEST
        BlockFace.UP -> Direction.UP
        BlockFace.WEST -> Direction.WEST
        BlockFace.WEST_NORTH_WEST -> Direction.WEST_NORTHWEST
        BlockFace.WEST_SOUTH_WEST -> Direction.WEST_SOUTHWEST
    }
})

fun BlockFace.toDirection(): Direction = blockFaceMap.getValue(this)
fun Direction.toBlockFace(): BlockFace = blockFaceMap.inverse().getValue(this)
