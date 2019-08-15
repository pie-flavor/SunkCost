package flavor.pie.sunkcost.scoreboards

import flavor.pie.kludge.*
import flavor.pie.sunkcost.stringByCode
import flavor.pie.sunkcost.textByCode
import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.Score
import org.bukkit.scoreboard.Scoreboard
import org.spongepowered.api.scoreboard.objective.Objective as SObjective

class SunkObjective(val objective: SObjective) : Objective {
    override fun isModifiable(): Boolean {
        return true // deficiency
    }

    override fun getCriteria(): String = objective.criterion.bId()

    override fun getName(): String = objective.name

    override fun getDisplayName(): String = objective.displayName.stringByCode()

    override fun getScoreboard(): Scoreboard = SunkScoreboard(objective.scoreboards.first())

    override fun setDisplaySlot(slot: DisplaySlot) =
        objective.scoreboards.first().updateDisplaySlot(objective, slot.sDisplaySlot())

    override fun unregister() = objective.scoreboards.first().removeObjective(objective)

    override fun getDisplaySlot(): DisplaySlot {
        TODO("not implemented") // deficiency
    }

    override fun setDisplayName(displayName: String) {
        objective.displayName = displayName.textByCode()
    }

    override fun getScore(player: OfflinePlayer): Score =
        SunkScore(objective.getOrCreateScore(player.name.text()), objective.scoreboards.first())

    override fun getScore(entry: String): Score =
        SunkScore(objective.getOrCreateScore(entry.textByCode()), objective.scoreboards.first())

    override fun equals(other: Any?): Boolean = other is SunkObjective && other.objective == objective

    override fun hashCode(): Int = objective.hashCode()

}
