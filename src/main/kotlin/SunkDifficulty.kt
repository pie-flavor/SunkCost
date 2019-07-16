package flavor.pie.sunkcost

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.Difficulty
import org.spongepowered.api.world.difficulty.Difficulties
import org.spongepowered.api.world.difficulty.Difficulty as SDifficulty

private val difficultyMap: BiMap<Difficulty, SDifficulty> = HashBiMap.create(Difficulty.values().associate {
    it to when (it) {
        Difficulty.EASY -> Difficulties.EASY
        Difficulty.HARD -> Difficulties.HARD
        Difficulty.NORMAL -> Difficulties.NORMAL
        Difficulty.PEACEFUL -> Difficulties.PEACEFUL
    }
})

fun Difficulty.sDifficulty(): SDifficulty = difficultyMap.getValue(this)

fun SDifficulty.bDifficulty(): Difficulty = difficultyMap.inverse()[this] ?: TODO("modded")