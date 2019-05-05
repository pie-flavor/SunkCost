package flavor.pie.sunkcost.entity

import org.bukkit.entity.Animals
import org.spongepowered.api.entity.living.animal.Animal

open class SunkAnimals(override val entity: Animal) : SunkAgeable(entity), Animals
