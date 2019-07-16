package flavor.pie.sunkcost.entity.animal

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import flavor.pie.kludge.*
import flavor.pie.sunkcost.entity.SunkProxySittable
import flavor.pie.sunkcost.entity.SunkTameable
import org.bukkit.entity.Ocelot
import org.bukkit.entity.Sittable
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.OcelotType
import org.spongepowered.api.data.type.OcelotTypes
import org.spongepowered.api.entity.living.animal.Ocelot as SOcelot

open class SunkOcelot(override val entity: SOcelot) : SunkTameable(entity), Ocelot, Sittable by SunkProxySittable(
    entity
) {

    companion object {
        private val ocelotTypeMap: BiMap<Ocelot.Type, OcelotType> = HashBiMap.create(mapOf(
            Ocelot.Type.BLACK_CAT to OcelotTypes.BLACK_CAT,
            Ocelot.Type.RED_CAT to OcelotTypes.RED_CAT,
            Ocelot.Type.SIAMESE_CAT to OcelotTypes.SIAMESE_CAT,
            Ocelot.Type.WILD_OCELOT to OcelotTypes.WILD_OCELOT
        ))
        fun Ocelot.Type.sOcelotType(): OcelotType = ocelotTypeMap.getValue(this)
        fun OcelotType.bOcelotType(): Ocelot.Type = ocelotTypeMap.inverse().getValue(this)
    }

    override fun getCatType(): Ocelot.Type = entity[Keys.OCELOT_TYPE].unwrap()?.bOcelotType() ?: Ocelot.Type.WILD_OCELOT

    override fun setCatType(type: Ocelot.Type) {
        entity[Keys.OCELOT_TYPE] = type.sOcelotType()
    }
}
