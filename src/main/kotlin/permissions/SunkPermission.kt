package flavor.pie.sunkcost.permissions

import flavor.pie.kludge.*
import flavor.pie.sunkcost.textByCode
import org.bukkit.permissions.PermissionDefault
import org.spongepowered.api.service.permission.PermissionDescription
import org.spongepowered.api.service.permission.PermissionService
import org.bukkit.permissions.Permission as Permission

object Permissions {
    const val OP = "sunkcost.op"
}

fun Permission.toPermissionBuilder(): PermissionDescription.Builder {
    val svc: PermissionService by UncheckedService
    val builder = svc.newDescriptionBuilder(plugin)
    when (default) {
        PermissionDefault.FALSE -> builder.assign(PermissionDescription.ROLE_ADMIN, false)
            .assign(PermissionDescription.ROLE_STAFF, false)
            .assign(PermissionDescription.ROLE_USER, false)
        PermissionDefault.NOT_OP -> builder.assign(PermissionDescription.ROLE_ADMIN, false)
            .assign(PermissionDescription.ROLE_STAFF, false)
            .assign(PermissionDescription.ROLE_USER, true)
        PermissionDefault.OP -> builder.assign(PermissionDescription.ROLE_ADMIN, true)
            .assign(PermissionDescription.ROLE_STAFF, true)
            .assign(PermissionDescription.ROLE_USER, false)
        PermissionDefault.TRUE -> builder.assign(PermissionDescription.ROLE_ADMIN, true)
            .assign(PermissionDescription.ROLE_STAFF, true)
            .assign(PermissionDescription.ROLE_USER, true)
        null -> {}
    }
    return builder.description(this.description.textByCode())
        .id(this.name)
}