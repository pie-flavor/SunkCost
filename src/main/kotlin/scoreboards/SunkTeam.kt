@file:Suppress("DEPRECATION")

package flavor.pie.sunkcost.scoreboards

import flavor.pie.kludge.*
import flavor.pie.sunkcost.SunkOfflinePlayer
import flavor.pie.sunkcost.chatColor
import flavor.pie.sunkcost.stringByCode
import flavor.pie.sunkcost.textByCode
import flavor.pie.sunkcost.textColor
import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.NameTagVisibility
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.Team
import org.spongepowered.api.service.user.UserStorageService
import org.spongepowered.api.text.Text
import org.spongepowered.api.scoreboard.Team as STeam

class SunkTeam(val team: STeam) : Team {
    override fun setNameTagVisibility(visibility: NameTagVisibility) {
        team.nameTagVisibility = visibility.visibility()
    }

    override fun getName(): String = team.name

    override fun hasEntry(entry: String): Boolean = entry.textByCode() in team

    override fun setCanSeeFriendlyInvisibles(enabled: Boolean) {
        team.setCanSeeFriendlyInvisibles(enabled)
    }

    override fun getSize(): Int = team.members.size

    override fun addPlayer(player: OfflinePlayer) = team.addMember(player.name.text())

    override fun removePlayer(player: OfflinePlayer): Boolean = team.removeMember(player.name.text())

    override fun setSuffix(suffix: String) {
        team.suffix = suffix.textByCode()
    }

    override fun removeEntry(entry: String): Boolean = team.removeMember(entry.textByCode())

    private val svc: UserStorageService by UncheckedService

    override fun getPlayers(): Set<OfflinePlayer> =
        team.members.mapNotNull { svc[it.stringByCode()].unwrap()?.let(::SunkOfflinePlayer) }.toSet()

    override fun addEntry(entry: String) = team.addMember(entry.textByCode())

    override fun setAllowFriendlyFire(enabled: Boolean) = team.setAllowFriendlyFire(enabled)

    override fun canSeeFriendlyInvisibles(): Boolean = team.canSeeFriendlyInvisibles()

    override fun getColor(): ChatColor = team.color.chatColor()

    override fun allowFriendlyFire(): Boolean = team.allowFriendlyFire()

    override fun getOption(option: Team.Option): Team.OptionStatus {
        return when (option) {
            Team.Option.COLLISION_RULE -> team.collisionRule.optionStatus()
            Team.Option.DEATH_MESSAGE_VISIBILITY -> team.deathMessageVisibility.optionStatus()
            Team.Option.NAME_TAG_VISIBILITY -> team.nameTagVisibility.optionStatus()
        }
    }

    override fun getDisplayName(): String = team.displayName.stringByCode()

    override fun setPrefix(prefix: String) {
        team.prefix = prefix.textByCode()
    }

    override fun getNameTagVisibility(): NameTagVisibility = team.nameTagVisibility.nameTagVisibility()

    override fun setOption(option: Team.Option, status: Team.OptionStatus) {
        when (option) {
            Team.Option.NAME_TAG_VISIBILITY -> team.nameTagVisibility = status.visibility()
            Team.Option.DEATH_MESSAGE_VISIBILITY -> team.deathMessageVisibility = status.visibility()
            Team.Option.COLLISION_RULE -> team.collisionRule = status.collisionRule()
        }
    }

    override fun getEntries(): Set<String> = team.members.map(Text::stringByCode).toSet()

    override fun getScoreboard(): Scoreboard? = team.scoreboard.unwrap()?.let(::SunkScoreboard)

    override fun setColor(color: ChatColor) {
        team.color = color.textColor() ?: throw IllegalArgumentException("color")
    }

    override fun getPrefix(): String = team.prefix.stringByCode()

    override fun getSuffix(): String = team.suffix.stringByCode()

    override fun unregister() {
        if (!team.unregister()) {
            throw IllegalStateException()
        }
    }

    override fun hasPlayer(player: OfflinePlayer): Boolean = player.name.text() in team

    override fun setDisplayName(displayName: String) {
        team.displayName = displayName.textByCode()
    }

    override fun equals(other: Any?): Boolean = other is SunkTeam && team == other.team

    override fun hashCode(): Int = team.hashCode()
}
