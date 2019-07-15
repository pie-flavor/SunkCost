package flavor.pie.sunkcost.entity.animal

import flavor.pie.kludge.*
import flavor.pie.sunkcost.bDyeColor
import flavor.pie.sunkcost.sDyeColor
import org.bukkit.DyeColor
import org.bukkit.entity.Sheep
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.DyeColors
import org.spongepowered.api.entity.living.animal.Sheep as SSheep

open class SunkSheep(override val entity: SSheep) : SunkAnimals(entity), Sheep {

    override fun isSheared(): Boolean = entity[Keys.IS_SHEARED].unwrap() ?: false

    override fun setSheared(flag: Boolean) {
        entity[Keys.IS_SHEARED] = flag
    }

    override fun setColor(color: DyeColor) {
        entity[Keys.DYE_COLOR] = color.sDyeColor()
    }

    override fun getColor(): DyeColor = entity[Keys.DYE_COLOR].orElse(DyeColors.WHITE).bDyeColor()

}