package flavor.pie.sunkcost.entity.animal

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import flavor.pie.kludge.*
import org.bukkit.entity.Rabbit
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.RabbitType
import org.spongepowered.api.data.type.RabbitTypes
import org.spongepowered.api.entity.living.animal.Rabbit as SRabbit

open class SunkRabbit(override val entity: SRabbit) : SunkAnimals(entity), Rabbit {

    companion object {
        private val rabbitTypeMap: BiMap<Rabbit.Type, RabbitType> = HashBiMap.create(Rabbit.Type.values().associate {
            it to when (it) {
                Rabbit.Type.BLACK -> RabbitTypes.BLACK
                Rabbit.Type.BLACK_AND_WHITE -> RabbitTypes.BLACK_AND_WHITE
                Rabbit.Type.BROWN -> RabbitTypes.BROWN
                Rabbit.Type.GOLD -> RabbitTypes.GOLD
                Rabbit.Type.SALT_AND_PEPPER -> RabbitTypes.SALT_AND_PEPPER
                Rabbit.Type.THE_KILLER_BUNNY -> RabbitTypes.KILLER
                Rabbit.Type.WHITE -> RabbitTypes.WHITE
            }
        })
        fun Rabbit.Type.sRabbitType(): RabbitType = rabbitTypeMap.getValue(this)
        fun RabbitType.bRabbitType(): Rabbit.Type = rabbitTypeMap.inverse()[this] ?: TODO("modded")
    }

    override fun setRabbitType(type: Rabbit.Type) {
        entity[Keys.RABBIT_TYPE] = type.sRabbitType()
    }

    override fun getRabbitType(): Rabbit.Type = entity[Keys.RABBIT_TYPE].unwrap()?.bRabbitType() ?: Rabbit.Type.BROWN

}