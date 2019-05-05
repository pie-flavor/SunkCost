package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Tameable
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.living.animal.Animal
import java.util.UUID

open class SunkTameable(entity: Animal) : SunkAnimals(entity), Tameable {

    companion object {
        val NOTCH_UUID: UUID = UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5")
    }

    override fun isTamed(): Boolean = entity[Keys.TAMED_OWNER].isPresent

    override fun setOwner(tamer: AnimalTamer?) {
        entity[Keys.TAMED_OWNER] = tamer?.uniqueId.optional()
    }

    override fun getOwner(): AnimalTamer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTamed(tame: Boolean) {
        entity[Keys.TAMED_OWNER] = NOTCH_UUID.optional()
    }
}