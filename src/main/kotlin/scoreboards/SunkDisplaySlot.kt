package flavor.pie.sunkcost.scoreboards

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.scoreboard.DisplaySlot
import org.spongepowered.api.scoreboard.displayslot.DisplaySlots
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot as SDisplaySlot

private val displaySlotMap: BiMap<DisplaySlot, SDisplaySlot> = HashBiMap.create(mapOf(
    DisplaySlot.BELOW_NAME to DisplaySlots.BELOW_NAME,
    DisplaySlot.PLAYER_LIST to DisplaySlots.LIST,
    DisplaySlot.SIDEBAR to DisplaySlots.SIDEBAR
))

fun DisplaySlot.sDisplaySlot(): SDisplaySlot = displaySlotMap.getValue(this)
fun SDisplaySlot.bDisplaySlot(): DisplaySlot = displaySlotMap.inverse().getValue(this)
