package flavor.pie.sunkcost

import org.bukkit.Bukkit
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GamePreInitializationEvent
import org.spongepowered.api.plugin.Plugin

@Plugin(id = "sunkcost", name = "SunkCost", version = "1.0-SNAPSHOT", description = "Runs Bukkit plugins on Sponge.", authors = ["pie_flavor"])
class SunkCost {

    @Listener
    fun onPreInit(e: GamePreInitializationEvent) {
        Bukkit.setServer(SunkServer)
    }

}
