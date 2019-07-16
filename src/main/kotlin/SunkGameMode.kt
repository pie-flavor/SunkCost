package flavor.pie.sunkcost

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.GameMode
import org.spongepowered.api.entity.living.player.gamemode.GameModes
import org.spongepowered.api.entity.living.player.gamemode.GameMode as SGameMode

val gameModeMap: BiMap<GameMode, SGameMode> = HashBiMap.create(GameMode.values().associate {
    it to when (it) {
        GameMode.ADVENTURE -> GameModes.ADVENTURE
        GameMode.CREATIVE -> GameModes.CREATIVE
        GameMode.SPECTATOR -> GameModes.SPECTATOR
        GameMode.SURVIVAL -> GameModes.SURVIVAL
    }
})

fun GameMode.sGameMode(): SGameMode = gameModeMap.getValue(this)
fun SGameMode.bGameMode(): GameMode = gameModeMap.inverse()[this] ?: TODO("modded")
