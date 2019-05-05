package flavor.pie.sunkcost

import flavor.pie.kludge.*
import org.bukkit.Bukkit
import org.spongepowered.api.config.ConfigDir
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.persistence.DataFormats
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GamePreInitializationEvent
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.serializer.TextSerializers
import java.nio.file.Files
import java.nio.file.Path
import java.util.UUID
import javax.inject.Inject

@Plugin(id = SunkCost.ID, name = SunkCost.NAME, version = SunkCost.VERSION, description = SunkCost.DESCRIPTION, authors = ["pie_flavor"])
class SunkCost @Inject constructor(@ConfigDir(sharedRoot = false) val dir: Path) {

    companion object {
        const val ID = "sunkcost"
        const val NAME = "SunkCost"
        const val VERSION = "1.0-SNAPSHOT"
        const val DESCRIPTION = "Runs Bukkit plugins on Sponge."
    }

    init {
        plugin = this
    }

    @Listener
    fun onPreInit(e: GamePreInitializationEvent) {
        Bukkit.setServer(SunkServer)
        val dataPath = dir.resolve("$ID.dat")
        if (Files.exists(dataPath)) {
            val container = Files.newInputStream(dataPath).use { DataFormats.NBT.readFrom(it) }
            SunkServer.serverId = container.getString(DataQuery.of("ServerID")).get()
        } else {
            val id = UUID.randomUUID().toString()
            SunkServer.serverId = id
            val container = DataContainer.createNew()
            container[DataQuery.of("ServerID")] = id
            Files.newOutputStream(dataPath).use { DataFormats.NBT.writeTo(it, container) }
        }
    }

}

@Suppress("DEPRECATION")
fun String.textByCode(): Text = TextSerializers.LEGACY_FORMATTING_CODE.deserialize(this)

@Suppress("DEPRECATION")
fun Text.stringByCode(): String = TextSerializers.LEGACY_FORMATTING_CODE.serialize(this)
