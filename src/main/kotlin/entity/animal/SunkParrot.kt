package flavor.pie.sunkcost.entity.animal

import flavor.pie.kludge.*
import flavor.pie.sunkcost.entity.SunkProxySittable
import flavor.pie.sunkcost.entity.SunkTameable
import org.bukkit.entity.Parrot
import org.bukkit.entity.Sittable
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.ParrotVariant
import org.spongepowered.api.entity.living.animal.Parrot as SParrot

open class SunkParrot(override val entity: SParrot) : SunkTameable(entity), Sittable by SunkProxySittable(
    entity
),
    Parrot {

    companion object {
        fun Parrot.Variant.sParrotVariant(): ParrotVariant = TODO()
        fun ParrotVariant.bParrotVariant(): Parrot.Variant = TODO()
    }

    override fun setVariant(variant: Parrot.Variant) {
        entity[Keys.PARROT_VARIANT] = variant.sParrotVariant()
    }

    override fun getVariant(): Parrot.Variant = entity[Keys.PARROT_VARIANT].unwrap()?.bParrotVariant() ?: Parrot.Variant.RED
}