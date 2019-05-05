package flavor.pie.sunkcost

import org.bukkit.Difficulty
import org.spongepowered.api.world.difficulty.Difficulties
import org.spongepowered.api.world.difficulty.Difficulty as SDifficulty

fun Difficulty.sDifficulty(): SDifficulty = when (this) {
    Difficulty.EASY -> Difficulties.EASY
    Difficulty.HARD -> Difficulties.HARD
    Difficulty.NORMAL -> Difficulties.NORMAL
    Difficulty.PEACEFUL -> Difficulties.PEACEFUL
}

fun SDifficulty.bDifficulty(): Difficulty = when (this) {
    Difficulties.EASY -> Difficulty.EASY
    Difficulties.HARD -> Difficulty.HARD
    Difficulties.NORMAL -> Difficulty.NORMAL
    Difficulties.PEACEFUL -> Difficulty.PEACEFUL
    else -> throw IllegalArgumentException("this") //todo modded
}