package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import org.bukkit.entity.Sittable
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.Entity

class SunkProxySittable(val entity: Entity) : Sittable {

    override fun setSitting(sitting: Boolean) {
        entity[Keys.IS_SITTING] = sitting
    }

    override fun isSitting(): Boolean = entity[Keys.IS_SITTING].unwrap() ?: false
}