package flavor.pie.sunkcost

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.bukkit.DyeColor
import org.spongepowered.api.data.type.DyeColors
import org.spongepowered.api.data.type.DyeColor as SDyeColor

private val dyeColorMap: BiMap<DyeColor, SDyeColor> = HashBiMap.create(mapOf(
    DyeColor.BLACK to DyeColors.BLACK,
    DyeColor.SILVER to DyeColors.SILVER,
    DyeColor.GRAY to DyeColors.GRAY,
    DyeColor.WHITE to DyeColors.WHITE,
    DyeColor.PINK to DyeColors.PINK,
    DyeColor.RED to DyeColors.RED,
    DyeColor.ORANGE to DyeColors.ORANGE,
    DyeColor.YELLOW to DyeColors.YELLOW,
    DyeColor.LIME to DyeColors.LIME,
    DyeColor.GREEN to DyeColors.GREEN,
    DyeColor.LIGHT_BLUE to DyeColors.LIGHT_BLUE,
    DyeColor.CYAN to DyeColors.CYAN,
    DyeColor.BLUE to DyeColors.BLUE,
    DyeColor.MAGENTA to DyeColors.MAGENTA,
    DyeColor.PURPLE to DyeColors.PURPLE,
    DyeColor.BROWN to DyeColors.BROWN
))

fun DyeColor.sDyeColor(): SDyeColor = dyeColorMap.getValue(this)

fun SDyeColor.bDyeColor(): DyeColor = dyeColorMap.inverse()[this] ?: TODO("modded")
