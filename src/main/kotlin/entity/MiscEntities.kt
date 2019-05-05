package flavor.pie.sunkcost.entity

import org.bukkit.entity.Chicken
import org.bukkit.entity.Cow
import org.bukkit.entity.PolarBear
import org.spongepowered.api.entity.living.animal.Chicken as SChicken
import org.spongepowered.api.entity.living.animal.Cow as SCow
import org.spongepowered.api.entity.living.animal.PolarBear as SPolarBear

open class SunkChicken(override val entity: SChicken) : SunkAnimals(entity), Chicken
open class SunkCow(override val entity: SCow) : SunkAnimals(entity), Cow
open class SunkPolarBear(override val entity: SPolarBear) : SunkAnimals(entity), PolarBear
