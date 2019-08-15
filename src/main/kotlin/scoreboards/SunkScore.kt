package flavor.pie.sunkcost.scoreboards

import flavor.pie.kludge.*
import flavor.pie.sunkcost.SunkOfflinePlayer
import flavor.pie.sunkcost.stringByCode
import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.Score
import org.bukkit.scoreboard.Scoreboard
import org.spongepowered.api.service.user.UserStorageService
import org.spongepowered.api.scoreboard.Score as SScore
import org.spongepowered.api.scoreboard.Scoreboard as SScoreboard

class SunkScore(val score: SScore, val board: SScoreboard): Score {
    override fun setScore(score: Int) {
        this.score.score = score
    }

    override fun getEntry(): String = score.name.stringByCode()

    override fun getScoreboard(): Scoreboard = SunkScoreboard(board)

    override fun isScoreSet(): Boolean = true

    val svc: UserStorageService by UncheckedService

    override fun getPlayer(): OfflinePlayer? = svc[entry].unwrap()?.let(::SunkOfflinePlayer)

    override fun getObjective(): Objective = SunkObjective(score.objectives.first())

    override fun getScore(): Int = score.score

    override fun equals(other: Any?): Boolean {
        return other is SunkScore && score == other.score && board == other.board
    }

    override fun hashCode(): Int = score.hashCode()
}
