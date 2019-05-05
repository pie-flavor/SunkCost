package flavor.pie.sunkcost.permissions

import flavor.pie.kludge.*
import org.bukkit.permissions.Permissible
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.service.permission.PermissionService
import org.spongepowered.api.service.permission.Subject
import java.util.WeakHashMap

class SunkProxyEntityPermissible(private val proxy: Entity) : Permissible by SunkProxyPermissible(proxy.getSubject()) {

    companion object {
        private val subjects: WeakHashMap<Entity, Subject> = WeakHashMap()
        fun Entity.getSubject(): Subject {
            val svc: PermissionService by UncheckedService
            val groups = svc.groupSubjects
            val id = this.uniqueId.toString()
            return if (!subjects.containsKey(this)) {
                val subject = groups.getSubject(id).unwrap()
                if (subject != null) {
                    subjects[this] = subject
                    subject
                } else {
                    val created = groups.newSubjectReference(id).resolve().get()
                    subjects[this] = created
                    created
                }
            } else {
                subjects[this]!!
            }
        }
    }

}

fun Entity.toPermissible() =
    if (this is Subject) {
        SunkProxyPermissible(this)
    } else {
        SunkProxyEntityPermissible(this)
    }