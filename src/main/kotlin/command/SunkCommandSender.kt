package flavor.pie.sunkcost.command

import flavor.pie.sunkcost.SunkServer
import flavor.pie.sunkcost.permissions.SunkProxyPermissible
import flavor.pie.sunkcost.text
import flavor.pie.sunkcost.textByCode
import flavor.pie.sunkcost.toText
import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.Server
import org.bukkit.command.CommandSender
import org.bukkit.permissions.Permissible
import org.spongepowered.api.command.CommandSource

open class SunkCommandSender(val source: CommandSource) : CommandSender, Permissible by SunkProxyPermissible(source) {

    override fun sendMessage(message: String) {
        source.sendMessage(message.textByCode())
    }

    override fun sendMessage(messages: Array<out String>) {
        source.sendMessage(messages.map { it.textByCode() }.text())
    }

    override fun spigot(): CommandSender.Spigot = Spigot(this)

    override fun getName(): String = source.name

    override fun getServer(): Server = SunkServer

    class Spigot(private val sender: SunkCommandSender) : CommandSender.Spigot() {

        override fun sendMessage(component: BaseComponent) {
            sender.source.sendMessage(component.toText())
        }

        override fun sendMessage(vararg components: BaseComponent) {
            sender.source.sendMessage(components.map { it.toText() }.text())
        }
    }
}