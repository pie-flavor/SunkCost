package flavor.pie.sunkcost.entity.animal

import flavor.pie.kludge.*
import org.bukkit.entity.Rabbit
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.RabbitType
import org.spongepowered.api.entity.living.animal.Rabbit as SRabbit

open class SunkRabbit(override val entity: SRabbit) : SunkAnimals(entity), Rabbit {

    companion object {
        fun Rabbit.Type.sRabbitType(): RabbitType = TODO()
        fun RabbitType.bRabbitType(): Rabbit.Type = TODO()
    }

    override fun setRabbitType(type: Rabbit.Type) {
        entity[Keys.RABBIT_TYPE] = type.sRabbitType()
    }

    override fun getRabbitType(): Rabbit.Type = entity[Keys.RABBIT_TYPE].unwrap()?.bRabbitType() ?: Rabbit.Type.BROWN

}