package flavor.pie.sunkcost.entity

import flavor.pie.kludge.*
import flavor.pie.sunkcost.SunkServer
import flavor.pie.sunkcost.SunkWorld
import flavor.pie.sunkcost.location
import flavor.pie.sunkcost.metadata.SunkProxyMetadatable
import flavor.pie.sunkcost.permissions.toPermissible
import flavor.pie.sunkcost.stringByCode
import flavor.pie.sunkcost.textByCode
import flavor.pie.sunkcost.transform
import flavor.pie.sunkcost.util.bVector
import flavor.pie.sunkcost.util.vector3d
import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.EntityEffect
import org.bukkit.Location
import org.bukkit.Server
import org.bukkit.World
import org.bukkit.block.PistonMoveReaction
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.metadata.Metadatable
import org.bukkit.permissions.Permissible
import org.bukkit.util.Vector
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.text.Text
import java.util.Locale
import java.util.UUID
import org.spongepowered.api.entity.Entity as SEntity

abstract class SunkEntity protected constructor(open val entity: SEntity) : Entity, Metadatable by SunkProxyMetadatable(entity), Permissible by entity.toPermissible() {

    companion object {
        operator fun invoke(entity: SEntity): SunkEntity {
            TODO()
        }
        internal fun of(entity: SEntity): SunkEntity = invoke(entity)
    }

    override fun setFireTicks(ticks: Int) {
        entity[Keys.FIRE_TICKS] = ticks
    }

    override fun teleport(location: Location): Boolean {
        entity.setVehicle(null)
        return entity.setTransform(location.transform())
    }

    override fun teleport(location: Location?, cause: PlayerTeleportEvent.TeleportCause?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun teleport(destination: Entity): Boolean {
        entity.setVehicle(null)
        return entity.setTransform((destination as SunkEntity).entity.transform)
    }

    override fun teleport(destination: Entity?, cause: PlayerTeleportEvent.TeleportCause?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasGravity(): Boolean = entity[Keys.HAS_GRAVITY].unwrap() ?: true

    override fun setPassenger(passenger: Entity?): Boolean {
        return if (passenger == null) {
            entity.clearPassengers()
            true
        } else {
            entity.addPassenger((passenger as SunkEntity).entity)
        }
    }

    override fun isDead(): Boolean = entity[Keys.HEALTH].unwrap() == 0.0 || entity.isRemoved

    override fun setFallDistance(distance: Float) {
        entity[Keys.FALL_DISTANCE] = distance
    }

    override fun isOnGround(): Boolean = entity.isOnGround

    override fun eject(): Boolean {
        return if (entity.passengers.isNotEmpty()) {
            entity.clearPassengers()
            true
        } else {
            false
        }
    }

    override fun isInsideVehicle(): Boolean = entity.vehicle.isPresent

    override fun setGlowing(flag: Boolean) {
        entity[Keys.GLOWING] = flag
    }

    override fun recalculatePermissions() {} // not exposed

    override fun setPortalCooldown(cooldown: Int) {} // not exposed

    override fun setGravity(gravity: Boolean) {
        entity[Keys.HAS_GRAVITY] = gravity
    }

    override fun getNearbyEntities(x: Double, y: Double, z: Double): List<Entity> = world.getNearbyEntities(location, x, y, z).toList()

    override fun sendMessage(message: String?) {} // not player

    override fun sendMessage(messages: Array<out String>?) {} // not player

    override fun getVehicle(): Entity? = entity.vehicle.unwrap()?.let { of(it) }

    override fun isCustomNameVisible(): Boolean = entity[Keys.CUSTOM_NAME_VISIBLE].unwrap() ?: false

    override fun spigot(): Entity.Spigot = Spigot(this)

    override fun getLocation(): Location = entity.transform.location()

    override fun getLocation(loc: Location): Location {
        val loc2 = location
        loc.x = loc2.x
        loc.y = loc2.y
        loc.z = loc2.z
        loc.pitch = loc2.pitch
        loc.yaw = loc2.yaw
        loc.world = loc2.world
        return loc2
    }

    override fun removePassenger(passenger: Entity): Boolean {
        entity.removePassenger((passenger as SunkEntity).entity)
        return true
    }

    override fun getHeight(): Double = entity.boundingBox.unwrap()?.size?.y ?: 0.0

    override fun isEmpty(): Boolean = entity.passengers.isEmpty()

    override fun getUniqueId(): UUID = entity.uniqueId

    override fun isGlowing(): Boolean = entity[Keys.GLOWING].unwrap() ?: false

    override fun getTicksLived(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isInvulnerable(): Boolean = entity[Keys.INVULNERABLE].unwrap() ?: false

    override fun setCustomNameVisible(flag: Boolean) {
        entity[Keys.CUSTOM_NAME_VISIBLE] = flag
    }

    override fun getCustomName(): String? = entity[Keys.DISPLAY_NAME].unwrap()?.stringByCode()

    override fun getName(): String = customName ?: entity.translation[Locale.ENGLISH]

    override fun getPistonMoveReaction(): PistonMoveReaction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addPassenger(passenger: Entity): Boolean = entity.addPassenger((passenger as SunkEntity).entity)

    override fun getMaxFireTicks(): Int = entity.getValue(Keys.FIRE_TICKS).unwrap()?.maxValue ?: -1

    override fun setVelocity(velocity: Vector) {
        entity.velocity = velocity.vector3d()
    }

    override fun getPassengers(): List<Entity> = entity.passengers.map { of(it) }

    override fun getLastDamageCause(): EntityDamageEvent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPortalCooldown(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isValid(): Boolean = !entity.isRemoved

    override fun getWorld(): World = SunkWorld(entity.world)

    override fun setLastDamageCause(event: EntityDamageEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addScoreboardTag(tag: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEntityId(): Int = entity.uniqueId.hashCode()

    override fun getPassenger(): Entity? = entity.passengers.firstOrNull()?.let { of(it) }

    override fun getFireTicks(): Int = entity[Keys.FIRE_TICKS].orElse(0)

    override fun remove() {
        entity.remove()
    }

    override fun getType(): EntityType = entity.type.bEntityType()

    override fun leaveVehicle(): Boolean = entity.setVehicle(null)

    override fun getScoreboardTags(): MutableSet<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSilent(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWidth(): Double = entity.boundingBox.unwrap()?.size?.z ?: 0.0

    override fun setTicksLived(value: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSilent(flag: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCustomName(name: String?) {
        if (name == null) {
            entity[Keys.DISPLAY_NAME] = Text.EMPTY
        } else {
            entity[Keys.DISPLAY_NAME] = name.textByCode()
        }
    }

    override fun getVelocity(): Vector = entity.velocity.bVector()

    override fun playEffect(type: EntityEffect?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeScoreboardTag(tag: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getServer(): Server = SunkServer

    override fun getFallDistance(): Float = entity[Keys.FALL_DISTANCE].orElse(0.0f)

    override fun setInvulnerable(flag: Boolean) {
        entity[Keys.INVULNERABLE] = flag
    }

    open class Spigot(private val entity: SunkEntity) : Entity.Spigot() {
        override fun sendMessage(component: BaseComponent) {} // not a player

        override fun sendMessage(vararg components: BaseComponent) {} // not a player

        override fun isInvulnerable(): Boolean = entity.isInvulnerable
    }

}