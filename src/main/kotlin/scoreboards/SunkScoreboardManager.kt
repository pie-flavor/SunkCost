package flavor.pie.sunkcost.scoreboards

import flavor.pie.kludge.*
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager
import org.spongepowered.api.scoreboard.Scoreboard as SScoreboard

object SunkScoreboardManager : ScoreboardManager {

    override fun getNewScoreboard(): Scoreboard = SunkScoreboard(SScoreboard.builder().build())

    override fun getMainScoreboard(): Scoreboard? = Server.serverScoreboard.unwrap()?.let(::SunkScoreboard)

}
