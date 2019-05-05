package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import org.bukkit.entity.Ocelot
import org.bukkit.entity.Sittable
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.OcelotType
import org.spongepowered.api.entity.living.animal.Ocelot as SOcelot

open class SunkOcelot(override val entity: SOcelot) : SunkTameable(entity), Ocelot, Sittable by SunkProxySittable(entity) {

    companion object {
        fun Ocelot.Type.sOcelotType(): OcelotType = TODO()
        fun OcelotType.bOcelotType(): Ocelot.Type = TODO()
    }

    override fun getCatType(): Ocelot.Type = entity[Keys.OCELOT_TYPE].unwrap()?.bOcelotType() ?: Ocelot.Type.WILD_OCELOT

    override fun setCatType(type: Ocelot.Type) {
        entity[Keys.OCELOT_TYPE] = type.sOcelotType()
    }
}