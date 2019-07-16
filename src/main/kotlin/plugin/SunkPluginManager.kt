package flavor.pie.sunkcost.plugin

import flavor.pie.sunkcost.permissions.toPermissionBuilder
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.permissions.Permissible
import org.bukkit.permissions.Permission
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginLoader
import org.bukkit.plugin.PluginManager
import java.io.File

object SunkPluginManager : PluginManager {

    override fun unsubscribeFromDefaultPerms(op: Boolean, permissible: Permissible?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlugin(name: String?): Plugin {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun callEvent(event: Event?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerInterface(loader: Class<out PluginLoader>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enablePlugin(plugin: Plugin?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadPlugins(directory: File?): Array<Plugin> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disablePlugins() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPermissions(): MutableSet<Permission> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPluginEnabled(name: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPluginEnabled(plugin: Plugin?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun useTimings(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removePermission(perm: Permission?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removePermission(name: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlugins(): Array<Plugin> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribeToDefaultPerms(op: Boolean, permissible: Permissible?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribeFromPermission(permission: String?, permissible: Permissible?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun recalculatePermissionDefaults(perm: Permission?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disablePlugin(plugin: Plugin?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerEvents(listener: Listener?, plugin: Plugin?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPermissionSubscriptions(permission: String?): MutableSet<Permissible> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addPermission(perm: Permission) {
        perm.toPermissionBuilder().register()
    }

    override fun getDefaultPermissions(op: Boolean): MutableSet<Permission> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearPlugins() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerEvent(
        event: Class<out Event>?,
        listener: Listener?,
        priority: EventPriority?,
        executor: EventExecutor?,
        plugin: Plugin?
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerEvent(
        event: Class<out Event>?,
        listener: Listener?,
        priority: EventPriority?,
        executor: EventExecutor?,
        plugin: Plugin?,
        ignoreCancelled: Boolean
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribeToPermission(permission: String, permissible: Permissible) {}

    override fun loadPlugin(file: File?): Plugin {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPermission(name: String?): Permission {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDefaultPermSubscriptions(op: Boolean): MutableSet<Permissible> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
