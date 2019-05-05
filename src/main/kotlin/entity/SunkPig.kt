package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import org.bukkit.entity.Pig
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.living.animal.Pig as SPig

open class SunkPig(override val entity: SPig) : SunkAnimals(entity), Pig {

    override fun setSaddle(saddled: Boolean) {
        entity[Keys.PIG_SADDLE] = saddled
    }

    override fun hasSaddle(): Boolean = entity[Keys.PIG_SADDLE].unwrap() ?: false
}