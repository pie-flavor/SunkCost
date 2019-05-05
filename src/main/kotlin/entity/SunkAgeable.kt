package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import org.bukkit.entity.Ageable
import org.bukkit.entity.LivingEntity
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.living.Ageable as SAgeable

open class SunkAgeable(override val entity: SAgeable) : SunkLivingEntity(entity), Ageable {

    override fun setAdult() {
        entity[Keys.IS_ADULT] = true
    }

    override fun setBaby() {
        entity[Keys.IS_ADULT] = false
    }

    override fun setAge(age: Int) {
        entity[Keys.AGE] = age
    }

    override fun getAge(): Int = entity[Keys.AGE].unwrap() ?: 0

    override fun canBreed(): Boolean = entity[Keys.CAN_BREED].unwrap() ?: false

    override fun isAdult(): Boolean = entity[Keys.IS_ADULT].unwrap() ?: true

    override fun setTarget(target: LivingEntity) {
        entity.setTarget((target as SunkEntity).entity)
    }

    override fun getTarget(): LivingEntity? = entity.target.unwrap()?.let { of(it) as LivingEntity } // autocast

    override fun getAgeLock(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAgeLock(lock: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBreed(breed: Boolean) {
        if (breed && !isAdult) {
            setAdult()
        } else {
            entity[Keys.CAN_BREED] = breed
        }
    }

}
