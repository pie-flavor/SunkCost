package flavor.pie.sunkcost

import flavor.pie.kludge.*
import flavor.pie.sunkcost.permissions.SunkProxyPermissible
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import org.bukkit.permissions.Permissible
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.living.player.User
import org.spongepowered.api.service.ban.BanService
import org.spongepowered.api.service.whitelist.WhitelistService
import java.util.UUID

open class SunkOfflinePlayer(val user: User): OfflinePlayer, Permissible by SunkProxyPermissible(user) {
    override fun isBanned(): Boolean {
        val svc: BanService by UncheckedService
        return svc.isBanned(user.profile)
    }

    override fun getName(): String = user.name

    override fun getBedSpawnLocation(): Location? {
        val spawn = user[Keys.RESPAWN_LOCATIONS].unwrap() ?: return null
        val world = user.worldUniqueId.unwrap() ?: Server.defaultWorld.unwrap()?.uniqueId ?: return null
        val respawn = spawn[world] ?: spawn.values.firstOrNull() ?: return null
        return respawn.asLocation().unwrap()?.bLocation()
    }

    override fun isWhitelisted(): Boolean {
        val svc: WhitelistService? by Service
        return svc?.isWhitelisted(user.profile) ?: false
    }

    override fun getPlayer(): Player? = user.player.unwrap()?.let { SunkPlayer(it) }

    override fun getUniqueId(): UUID = user.uniqueId

    override fun hasPlayedBefore(): Boolean = true

    override fun setWhitelisted(value: Boolean) {
        val svc: WhitelistService? by Service
        svc?.addProfile(user.profile)
    }

    override fun getLastPlayed(): Long = user[Keys.LAST_DATE_PLAYED].unwrap()?.epochSecond ?: 0

    override fun serialize(): MutableMap<String, Any> {
        TODO("serialization")
    }

    override fun getFirstPlayed(): Long = user[Keys.FIRST_DATE_PLAYED].unwrap()?.epochSecond ?: 0

    override fun isOnline(): Boolean = user.isOnline

    override fun equals(other: Any?): Boolean = other is OfflinePlayer && uniqueId == other.uniqueId

    override fun hashCode(): Int = uniqueId.hashCode()
}
