@file:Suppress("DEPRECATION")

package flavor.pie.sunkcost.scoreboards

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.scoreboard.NameTagVisibility
import org.spongepowered.api.scoreboard.Visibilities
import org.spongepowered.api.scoreboard.Visibility

private val nameTagVisibilityMap: BiMap<NameTagVisibility, Visibility> = HashBiMap.create(mapOf(
    NameTagVisibility.ALWAYS to Visibilities.ALWAYS,
    NameTagVisibility.HIDE_FOR_OTHER_TEAMS to Visibilities.HIDE_FOR_OTHER_TEAMS,
    NameTagVisibility.HIDE_FOR_OWN_TEAM to Visibilities.HIDE_FOR_OWN_TEAM,
    NameTagVisibility.NEVER to Visibilities.NEVER
))

fun NameTagVisibility.visibility(): Visibility = nameTagVisibilityMap.getValue(this)
fun Visibility.nameTagVisibility(): NameTagVisibility = nameTagVisibilityMap.inverse().getValue(this)
