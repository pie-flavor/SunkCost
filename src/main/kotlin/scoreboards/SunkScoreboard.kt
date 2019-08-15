package flavor.pie.sunkcost.scoreboards

import flavor.pie.kludge.*
import flavor.pie.sunkcost.SunkOfflinePlayer
import flavor.pie.sunkcost.stringByCode
import flavor.pie.sunkcost.textByCode
import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.Score
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.Team
import org.spongepowered.api.service.user.UserStorageService
import org.spongepowered.api.scoreboard.Scoreboard as SScoreboard
import org.spongepowered.api.scoreboard.Team as STeam
import org.spongepowered.api.scoreboard.objective.Objective as SObjective

class SunkScoreboard(val scoreboard: SScoreboard): Scoreboard {
    override fun getTeam(teamName: String): Team? = scoreboard.getTeam(teamName).unwrap()?.let(::SunkTeam)

    override fun getPlayerTeam(player: OfflinePlayer): Team? = scoreboard.getMemberTeam(player.name.text()).unwrap()?.let(::SunkTeam)

    override fun getTeams(): Set<Team> = scoreboard.teams.map(::SunkTeam).toSet()

    override fun getEntries(): Set<String> = scoreboard.scores.map { it.name.stringByCode() }.toSet()

    override fun clearSlot(slot: DisplaySlot) {
        scoreboard.clearSlot(slot.sDisplaySlot())
    }

    override fun getScores(player: OfflinePlayer): Set<Score> = scoreboard.getScores(player.name.text()).map { SunkScore(it, scoreboard) }.toSet()

    override fun getScores(entry: String): Set<Score> = scoreboard.getScores(entry.textByCode()).map { SunkScore(it, scoreboard) }.toSet()

    override fun resetScores(player: OfflinePlayer) {
        scoreboard.removeScores(player.name.text())
    }

    override fun resetScores(entry: String) {
        scoreboard.removeScores(entry.textByCode())
    }

    override fun getObjectives(): Set<Objective> = scoreboard.objectives.map(::SunkObjective).toSet()

    override fun getObjectivesByCriteria(criteria: String): Set<Objective> = getCriterionByBId(criteria)?.let { scoreboard.getObjectivesByCriteria(it).map(::SunkObjective).toSet() } ?: setOf()

    override fun registerNewTeam(name: String): Team = SunkTeam(STeam.builder().name(name).build().also { scoreboard.registerTeam(it) })

    val svc: UserStorageService by UncheckedService

    override fun getPlayers(): Set<OfflinePlayer> = entries.mapNotNull { svc[it].unwrap()?.let(::SunkOfflinePlayer) }.toSet()

    override fun getObjective(name: String): Objective? = scoreboard.getObjective(name).unwrap()?.let(::SunkObjective)

    override fun getObjective(slot: DisplaySlot): Objective? = scoreboard.getObjective(slot.sDisplaySlot()).unwrap()?.let(::SunkObjective)

    override fun registerNewObjective(name: String, criteria: String): Objective = SunkObjective(SObjective.builder().name(name).criterion(
        getCriterionByBId(criteria) ?: throw IllegalArgumentException("criteria")).build().also { scoreboard.addObjective(it) })

    override fun getEntryTeam(entry: String): Team? = scoreboard.getMemberTeam(entry.textByCode()).unwrap()?.let(::SunkTeam)

    override fun equals(other: Any?): Boolean = other is SunkScoreboard && other.scoreboard == scoreboard

    override fun hashCode(): Int = scoreboard.hashCode()
}
