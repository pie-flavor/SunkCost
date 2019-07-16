package flavor.pie.sunkcost.entity.animal

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import flavor.pie.kludge.*
import flavor.pie.sunkcost.entity.SunkProxySittable
import flavor.pie.sunkcost.entity.SunkTameable
import org.bukkit.entity.Parrot
import org.bukkit.entity.Sittable
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.ParrotVariant
import org.spongepowered.api.data.type.ParrotVariants
import org.spongepowered.api.entity.living.animal.Parrot as SParrot

open class SunkParrot(override val entity: SParrot) : SunkTameable(entity), Sittable by SunkProxySittable(
    entity
),
    Parrot {

    companion object {
        private val parrotVariantMap: BiMap<Parrot.Variant, ParrotVariant> = HashBiMap.create(Parrot.Variant.values().associate {
            it to when (it) {
                Parrot.Variant.BLUE -> ParrotVariants.BLUE
                Parrot.Variant.CYAN -> ParrotVariants.CYAN
                Parrot.Variant.GRAY -> ParrotVariants.GRAY
                Parrot.Variant.GREEN -> ParrotVariants.GREEN
                Parrot.Variant.RED -> ParrotVariants.RED
            }
        })
        fun Parrot.Variant.sParrotVariant(): ParrotVariant = parrotVariantMap.getValue(this)
        fun ParrotVariant.bParrotVariant(): Parrot.Variant = parrotVariantMap.inverse()[this] ?: TODO("modded")
    }

    override fun setVariant(variant: Parrot.Variant) {
        entity[Keys.PARROT_VARIANT] = variant.sParrotVariant()
    }

    override fun getVariant(): Parrot.Variant = entity[Keys.PARROT_VARIANT].unwrap()?.bParrotVariant() ?: Parrot.Variant.RED
}
