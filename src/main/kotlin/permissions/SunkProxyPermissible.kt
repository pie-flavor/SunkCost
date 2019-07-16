package flavor.pie.sunkcost.permissions

import org.bukkit.permissions.Permissible
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionAttachmentInfo
import org.bukkit.plugin.Plugin
import org.spongepowered.api.service.permission.Subject
import org.spongepowered.api.util.Tristate

class SunkProxyPermissible(private val subject: Subject) : Permissible {

    override fun getEffectivePermissions(): MutableSet<PermissionAttachmentInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPermissionSet(name: String): Boolean = subject.getPermissionValue(setOf(), name) != Tristate.UNDEFINED

    override fun isPermissionSet(perm: Permission): Boolean = isPermissionSet(perm.name)

    override fun addAttachment(plugin: Plugin?, name: String?, value: Boolean): PermissionAttachment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addAttachment(plugin: Plugin?): PermissionAttachment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addAttachment(plugin: Plugin?, name: String?, value: Boolean, ticks: Int): PermissionAttachment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addAttachment(plugin: Plugin?, ticks: Int): PermissionAttachment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isOp(): Boolean = hasPermission(Permissions.OP)

    override fun removeAttachment(attachment: PermissionAttachment?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun recalculatePermissions() {} // not exposed

    override fun hasPermission(name: String): Boolean = subject.hasPermission(name)

    override fun hasPermission(perm: Permission): Boolean = subject.hasPermission(perm.name)

    override fun setOp(value: Boolean) {
        subject.subjectData.setPermission(setOf(), Permissions.OP, Tristate.fromBoolean(value))
    }
}
