package flavor.pie.sunkcost.entity.animal

import flavor.pie.kludge.*
import flavor.pie.sunkcost.bDyeColor
import flavor.pie.sunkcost.entity.SunkProxySittable
import flavor.pie.sunkcost.entity.SunkTameable
import flavor.pie.sunkcost.sDyeColor
import org.bukkit.DyeColor
import org.bukkit.entity.Sittable
import org.bukkit.entity.Wolf
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.living.animal.Wolf as SWolf

open class SunkWolf(override val entity: SWolf) : SunkTameable(entity), Sittable by SunkProxySittable(
    entity
), Wolf {

    override fun setAngry(angry: Boolean) {
        entity[Keys.ANGRY] = angry
    }

    override fun setCollarColor(color: DyeColor) {
        entity[Keys.DYE_COLOR] = color.sDyeColor()
    }

    override fun isAngry(): Boolean = entity[Keys.ANGRY].unwrap() ?: false

    override fun getCollarColor(): DyeColor? = entity[Keys.DYE_COLOR].unwrap()?.bDyeColor()
}