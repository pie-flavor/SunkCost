package flavor.pie.sunkcost

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.Difficulty
import org.spongepowered.api.world.difficulty.Difficulties
import org.spongepowered.api.world.difficulty.Difficulty as SDifficulty

private val difficultyMap: BiMap<Difficulty, SDifficulty> = HashBiMap.create(mapOf(
    Difficulty.EASY to Difficulties.EASY,
    Difficulty.HARD to Difficulties.HARD,
    Difficulty.NORMAL to Difficulties.NORMAL,
    Difficulty.PEACEFUL to Difficulties.PEACEFUL
))

fun Difficulty.sDifficulty(): SDifficulty = difficultyMap.getValue(this)

fun SDifficulty.bDifficulty(): Difficulty = difficultyMap.inverse()[this] ?: TODO("modded")