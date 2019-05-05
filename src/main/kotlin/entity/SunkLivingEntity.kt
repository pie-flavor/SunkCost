package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import flavor.pie.sunkcost.SunkServer
import flavor.pie.sunkcost.SunkWorld
import flavor.pie.sunkcost.toBlock
import flavor.pie.sunkcost.toBlockType
import flavor.pie.sunkcost.vector3d
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeInstance
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.Projectile
import org.bukkit.inventory.EntityEquipment
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.util.Vector
import org.spongepowered.api.block.BlockTypes
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.property.block.SolidCubeProperty
import org.spongepowered.api.entity.EntityTypes
import org.spongepowered.api.entity.living.Living
import org.spongepowered.api.util.blockray.BlockRay
import kotlin.math.min

open class SunkLivingEntity(override val entity: Living) : LivingEntity, SunkDamageable(entity) {

    override fun getEyeLocation(): Location {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastDamage(): Double = entity[Keys.LAST_DAMAGE].unwrap().unwrap() ?: 0.0

    override fun addPotionEffects(effects: MutableCollection<PotionEffect>?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCollidable(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasPotionEffect(type: PotionEffectType?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLastDamage(damage: Double) {
        entity[Keys.LAST_DAMAGE] = damage.optional()
    }

    override fun getPotionEffect(type: PotionEffectType?): PotionEffect {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAI(ai: Boolean) {
        entity[Keys.AI_ENABLED] = ai
    }

    override fun isGliding(): Boolean = entity[Keys.IS_ELYTRA_FLYING].orElse(false)

    override fun getEquipment(): EntityEquipment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCanPickupItems(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTargetBlock(transparent: MutableSet<Material>?, maxDistance: Int): Block {
        val mats = transparent?.mapNotNull { it.toBlockType() }?.toSet() ?: setOf(BlockTypes.AIR)
        return BlockRay.from(entity)
            .stopFilter(BlockRay.continueAfterFilter({ it.mapBlock { w, v -> w.getBlockType(v) !in mats } }, 1))
            .distanceLimit(maxDistance.toDouble())
            .end().unwrap()
            ?.location
            ?.toBlock()
            ?: (entity.transform.direction.normalize() * maxDistance.toDouble() + entity.transform.position)
                .let { Location(SunkWorld(entity.world), it.x, it.y, it.z) }
                .block
    }

    override fun <T : Projectile?> launchProjectile(projectile: Class<out T>?): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Projectile?> launchProjectile(projectile: Class<out T>?, velocity: Vector?): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEyeHeight(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEyeHeight(ignorePose: Boolean): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMaximumAir(): Int = entity[Keys.MAX_AIR].orElse(-1)

    override fun setRemainingAir(ticks: Int) {
        entity[Keys.REMAINING_AIR] = ticks
    }

    override fun getLineOfSight(transparent: Set<Material>?, maxDistance: Int): List<Block> {
        val mats = transparent?.mapNotNull { it.toBlockType() }?.toSet() ?: setOf(BlockTypes.AIR)
        return BlockRay.from(entity)
            .stopFilter(BlockRay.continueAfterFilter({ it.mapBlock { w, v -> w.getBlockType(v) !in mats } }, 1))
            .distanceLimit(maxDistance.toDouble())
            .build()
            .asSequence()
            .map { it.location.toBlock() }
            .toList()
    }

    override fun getLeashHolder(): Entity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActivePotionEffects(): MutableCollection<PotionEffect> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastTwoTargetBlocks(transparent: Set<Material>?, maxDistance: Int): List<Block> {
        val mats = transparent?.mapNotNull { it.toBlockType() }?.toSet() ?: setOf(BlockTypes.AIR)
        return BlockRay.from(entity)
            .stopFilter(BlockRay.continueAfterFilter({ it.mapBlock { w, v -> w.getBlockType(v) !in mats } }, 1))
            .distanceLimit(min(maxDistance, 100).toDouble())
            .build()
            .asSequence()
            .map { it.location.toBlock() }
            .toList()
            .takeLast(2)
    }

    override fun hasLineOfSight(other: Entity): Boolean =
        BlockRay.from(entity)
            .to(other.location.vector3d())
            .skipFilter { it.mapBlock { w, v ->
                w.getBlock(v).getProperty(SolidCubeProperty::class.java).unwrap()?.value != true
            } }
            .build()
            .asSequence()
            .firstOrNull() == null

    override fun setMaximumNoDamageTicks(ticks: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRemoveWhenFarAway(remove: Boolean) {
        entity[Keys.PERSISTS] = remove
    }

    override fun setLeashHolder(holder: Entity?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCollidable(collidable: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCanPickupItems(pickup: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNoDamageTicks(): Int = entity[Keys.INVULNERABILITY_TICKS].orElse(0)

    override fun setGliding(gliding: Boolean) {
        entity[Keys.IS_ELYTRA_FLYING] = true
    }

    override fun setNoDamageTicks(ticks: Int) {
        entity[Keys.INVULNERABILITY_TICKS] = ticks
    }

    override fun getRemainingAir(): Int = entity[Keys.REMAINING_AIR].orElse(0)

    override fun isLeashed(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRemoveWhenFarAway(): Boolean = !entity[Keys.PERSISTS].orElse(false)

    override fun getAttribute(attribute: Attribute?): AttributeInstance {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKiller(): Player? {
        return if (!isDead) {
            null
        } else {
            val snapshot = entity[Keys.LAST_ATTACKER].unwrap().unwrap() ?: return null
            if (snapshot.type == EntityTypes.PLAYER) {
                snapshot.uniqueId.unwrap()?.let { SunkServer.getPlayer(it) }
            } else {
                null
            }
        }
    }

    override fun setMaximumAir(ticks: Int) {
        entity[Keys.MAX_AIR] = ticks
    }

    override fun getMaximumNoDamageTicks(): Int = entity.getValue(Keys.INVULNERABILITY_TICKS).unwrap()?.maxValue ?: 0

    override fun removePotionEffect(type: PotionEffectType?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addPotionEffect(effect: PotionEffect?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addPotionEffect(effect: PotionEffect?, force: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasAI(): Boolean = entity[Keys.AI_ENABLED].orElse(true)
}