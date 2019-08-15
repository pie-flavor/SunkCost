package flavor.pie.sunkcost.scoreboards

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.scoreboard.Team
import org.spongepowered.api.scoreboard.CollisionRule
import org.spongepowered.api.scoreboard.CollisionRules
import org.spongepowered.api.scoreboard.Visibilities
import org.spongepowered.api.scoreboard.Visibility

private val visibility: BiMap<Team.OptionStatus, Visibility> = HashBiMap.create(mapOf(
    Team.OptionStatus.ALWAYS to Visibilities.ALWAYS,
    Team.OptionStatus.FOR_OTHER_TEAMS to Visibilities.HIDE_FOR_OWN_TEAM,
    Team.OptionStatus.FOR_OWN_TEAM to Visibilities.HIDE_FOR_OWN_TEAM,
    Team.OptionStatus.NEVER to Visibilities.NEVER
))

fun Team.OptionStatus.visibility(): Visibility = visibility.getValue(this)
fun Visibility.optionStatus(): Team.OptionStatus = visibility.inverse().getValue(this)

private val collisionRuleMap: BiMap<Team.OptionStatus, CollisionRule> = HashBiMap.create(mapOf(
    Team.OptionStatus.NEVER to CollisionRules.NEVER,
    Team.OptionStatus.FOR_OWN_TEAM to CollisionRules.PUSH_OWN_TEAM,
    Team.OptionStatus.FOR_OTHER_TEAMS to CollisionRules.PUSH_OTHER_TEAMS,
    Team.OptionStatus.ALWAYS to CollisionRules.ALWAYS
))

fun Team.OptionStatus.collisionRule(): CollisionRule = collisionRuleMap.getValue(this)
fun CollisionRule.optionStatus(): Team.OptionStatus = collisionRuleMap.inverse().getValue(this)
