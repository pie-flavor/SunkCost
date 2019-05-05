package flavor.pie.sunkcost

import com.flowpowered.math.vector.Vector3d
import com.flowpowered.math.vector.Vector3i
import flavor.pie.sunkcost.block.SunkBlock
import org.bukkit.Location
import org.bukkit.block.Block
import org.spongepowered.api.entity.Transform
import org.spongepowered.api.world.extent.Extent
import org.spongepowered.api.world.World as SWorld
import org.spongepowered.api.world.Location as SLocation

fun SLocation<SWorld>.bLocation(): Location = Location(SunkWorld(extent), x, y, z)

fun Location.vector3i(): Vector3i = Vector3i(blockX, blockY, blockZ)

fun Location.vector3d(): Vector3d = Vector3d(x, y, z)

fun SLocation<SWorld>.toBlock(): Block = SunkBlock(this)

fun Location.transform(): Transform<SWorld> =
    Transform((world as SunkWorld).world, Vector3d(x, y, z), Vector3d(pitch.toDouble(), yaw.toDouble(), 0.0))

fun Transform<SWorld>.location() = Location(SunkWorld(extent), position.x, position.y, position.z, pitch.toFloat(), yaw.toFloat())