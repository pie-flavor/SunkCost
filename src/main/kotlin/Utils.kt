package flavor.pie.sunkcost

import flavor.pie.kludge.*
import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.HoverEvent
import net.md_5.bungee.api.chat.ScoreComponent
import net.md_5.bungee.api.chat.SelectorComponent
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.chat.TranslatableComponent
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.Slot
import org.spongepowered.api.item.inventory.property.SlotIndex
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.action.ClickAction
import org.spongepowered.api.text.action.HoverAction
import org.spongepowered.api.text.action.TextActions
import org.spongepowered.api.text.format.TextColor
import org.spongepowered.api.text.format.TextColors
import org.spongepowered.api.text.format.TextFormat
import org.spongepowered.api.text.format.TextStyle
import org.spongepowered.api.text.format.TextStyles
import org.spongepowered.api.text.selector.Selector

private val chatColorMap: Map<ChatColor, TextFormat> = mapOf(
    ChatColor.AQUA to TextColors.AQUA.format(),
    ChatColor.BLACK to TextColors.BLACK.format(),
    ChatColor.BLUE to TextColors.BLUE.format(),
    ChatColor.BOLD to TextStyles.BOLD.format(),
    ChatColor.DARK_AQUA to TextColors.DARK_AQUA.format(),
    ChatColor.DARK_BLUE to TextColors.DARK_BLUE.format(),
    ChatColor.DARK_GRAY to TextColors.DARK_GRAY.format(),
    ChatColor.DARK_GREEN to TextColors.DARK_GREEN.format(),
    ChatColor.DARK_PURPLE to TextColors.DARK_PURPLE.format(),
    ChatColor.DARK_RED to TextColors.DARK_RED.format(),
    ChatColor.GOLD to TextColors.GOLD.format(),
    ChatColor.GRAY to TextColors.GRAY.format(),
    ChatColor.GREEN to TextColors.GREEN.format(),
    ChatColor.ITALIC to TextStyles.ITALIC.format(),
    ChatColor.LIGHT_PURPLE to TextColors.LIGHT_PURPLE.format(),
    ChatColor.MAGIC to TextStyles.OBFUSCATED.format(),
    ChatColor.RED to TextColors.RED.format(),
    ChatColor.RESET to TextStyles.RESET.format(),
    ChatColor.STRIKETHROUGH to TextStyles.STRIKETHROUGH.format(),
    ChatColor.UNDERLINE to TextStyles.UNDERLINE.format(),
    ChatColor.WHITE to TextColors.WHITE.format(),
    ChatColor.YELLOW to TextColors.YELLOW.format()
)

fun ChatColor.textFormat(): TextFormat = chatColorMap.getValue(this)

fun TextColor.format(): TextFormat = TextFormat.of(this)
fun TextStyle.format(): TextFormat = TextFormat.of(this)

fun ClickEvent.clickAction(): ClickAction<*> {
    TODO()
}

fun HoverEvent.hoverAction(): HoverAction<*> {
    TODO()
}

fun BaseComponent.toText(): Text {
    val builder = when (this) {
        is TextComponent -> Text.builder(this.text)
        is TranslatableComponent -> GameRegistry.getTranslationById(this.translate).unwrap()?.let { Text.builder(it) } ?: Text.builder(this.translate)
        is ScoreComponent -> this.value?.let { Text.builder(it) } ?: Server.serverScoreboard.unwrap()?.getObjective(this.objective).unwrap()?.let { o -> Text.builder(o.getOrCreateScore(this.name.text())) } ?: Text.builder(this.objective)
        is SelectorComponent -> Text.builder(Selector.parse(this.selector))
        else -> Text.builder()
    }
    var format = if (this.colorRaw != null) {
        this.colorRaw.textFormat()
    } else {
        TextFormat.of()
    }
    if (this.isBoldRaw != null) {
        format = if (this.isBoldRaw) {
            format.merge(TextStyles.BOLD.format())
        } else {
            format.merge(TextStyles.BOLD.negate().format())
        }
    }
    if (this.isItalicRaw != null) {
        format = if (this.isItalicRaw) {
            format.merge(TextStyles.ITALIC.format())
        } else {
            format.merge(TextStyles.ITALIC.negate().format())
        }
    }
    if (this.isUnderlinedRaw != null) {
        format = if (this.isUnderlinedRaw) {
            format.merge(TextStyles.UNDERLINE.format())
        } else {
            format.merge(TextStyles.UNDERLINE.negate().format())
        }
    }
    if (this.isStrikethroughRaw != null) {
        format = if (this.isStrikethroughRaw) {
            format.merge(TextStyles.STRIKETHROUGH.format())
        } else {
            format.merge(TextStyles.STRIKETHROUGH.negate().format())
        }
    }
    if (this.isObfuscatedRaw != null) {
        format = if (this.isObfuscatedRaw) {
            format.merge(TextStyles.OBFUSCATED.format())
        } else {
            format.merge(TextStyles.OBFUSCATED.negate().format())
        }
    }
    builder.format(format)
    if (this.clickEvent != null) {
        builder.onClick(this.clickEvent.clickAction())
    }
    if (this.hoverEvent != null) {
        builder.onHover(this.hoverEvent.hoverAction())
    }
    if (this.insertion != null) {
        builder.onShiftClick(TextActions.insertText(this.insertion))
    }
    if (this.extra.isNotEmpty()) {
        builder.append(this.extra.map { it.toText() })
    }
    return builder.build()
}

fun Iterable<Text>.text(): Text = Text.builder().append(this).build()

val Slot.slotIndex: Int? get() = getInventoryProperty(SlotIndex::class.java).unwrap()?.value

fun Inventory.realInventory(): Inventory = slots.first().transform().root()
