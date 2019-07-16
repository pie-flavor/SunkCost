package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import org.bukkit.entity.Damageable
import org.bukkit.entity.Entity
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.event.cause.entity.damage.DamageTypes
import org.spongepowered.api.entity.Entity as SEntity

open class SunkDamageable(entity: SEntity): SunkEntity(entity), Damageable {

    override fun resetMaxHealth() {
        entity.remove(Keys.MAX_HEALTH)
    }

    override fun getMaxHealth(): Double = entity[Keys.MAX_HEALTH].unwrap() ?: Double.NaN

    override fun setHealth(health: Double) {
        if (health < 0 || health > maxHealth) {
            throw IllegalArgumentException("health")
        }
        entity[Keys.HEALTH] = health
    }

    override fun damage(amount: Double) {
        entity.damage(amount, damageSourceOf {
            absolute()
            creative()
            bypassesArmor()
            type(DamageTypes.CUSTOM)
        })
    }

    override fun damage(amount: Double, source: Entity) {
        CauseStackManager.pushCauseFrame().pushCause((source as SunkEntity).entity).use {
            entity.damage(amount, damageSourceOf {
                type(DamageTypes.ATTACK)
            })
        }
    }

    override fun getHealth(): Double = entity[Keys.HEALTH].unwrap() ?: Double.NaN

    override fun setMaxHealth(health: Double) {
        entity[Keys.MAX_HEALTH] = health
    }
}
