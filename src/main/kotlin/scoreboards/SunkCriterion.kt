package flavor.pie.sunkcost.scoreboards

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.scoreboard.Criterias
import org.spongepowered.api.scoreboard.critieria.Criteria
import org.spongepowered.api.scoreboard.critieria.Criterion

private val criterionMap: BiMap<String, Criterion> = HashBiMap.create(mapOf(
    Criterias.DEATHS to Criteria.DEATHS,
    Criterias.HEALTH to Criteria.HEALTH,
    Criterias.PLAYER_KILLS to Criteria.PLAYER_KILLS,
    Criterias.TOTAL_KILLS to Criteria.TOTAL_KILLS,
    "dummy" to Criteria.DUMMY,
    "trigger" to Criteria.TRIGGER
))

fun getCriterionByBId(id: String): Criterion? = criterionMap[id]

fun Criterion.bId(): String = criterionMap.inverse().getValue(this)
