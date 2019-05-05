package flavor.pie.sunkcost.util

import com.flowpowered.math.vector.Vector3d
import org.bukkit.util.Vector

fun Vector.vector3d(): Vector3d = Vector3d(x, y, z)
fun Vector3d.bVector(): Vector = Vector(x, y, z)