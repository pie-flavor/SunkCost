package flavor.pie.sunkcost

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.ChatColor
import org.spongepowered.api.text.format.TextColor
import org.spongepowered.api.text.format.TextColors

private val chatColorMap: BiMap<ChatColor, TextColor> = HashBiMap.create(mapOf(
    ChatColor.WHITE to TextColors.WHITE,
    ChatColor.LIGHT_PURPLE to TextColors.LIGHT_PURPLE,
    ChatColor.RED to TextColors.RED,
    ChatColor.DARK_RED to TextColors.RED,
    ChatColor.GOLD to TextColors.GOLD,
    ChatColor.YELLOW to TextColors.YELLOW,
    ChatColor.GREEN to TextColors.GREEN,
    ChatColor.DARK_GREEN to TextColors.DARK_GREEN,
    ChatColor.AQUA to TextColors.AQUA,
    ChatColor.DARK_AQUA to TextColors.DARK_AQUA,
    ChatColor.BLUE to TextColors.BLUE,
    ChatColor.DARK_BLUE to TextColors.DARK_BLUE,
    ChatColor.DARK_PURPLE to TextColors.DARK_PURPLE,
    ChatColor.GRAY to TextColors.GRAY,
    ChatColor.DARK_GRAY to TextColors.DARK_GRAY,
    ChatColor.BLACK to TextColors.BLACK
))

fun ChatColor.textColor(): TextColor? = chatColorMap[this]
fun TextColor.chatColor(): ChatColor = chatColorMap.inverse().getValue(this)
