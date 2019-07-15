package flavor.pie.sunkcost.entity.animal

import flavor.pie.sunkcost.entity.SunkAgeable
import org.bukkit.entity.Animals
import org.spongepowered.api.entity.living.animal.Animal

open class SunkAnimals(override val entity: Animal) : SunkAgeable(entity), Animals
