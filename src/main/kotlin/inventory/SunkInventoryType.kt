package flavor.pie.sunkcost.inventory

import org.bukkit.event.inventory.InventoryType
import org.spongepowered.api.item.inventory.InventoryArchetype
import org.spongepowered.api.item.inventory.InventoryArchetypes
import org.spongepowered.api.item.inventory.property.GuiId
import org.spongepowered.api.item.inventory.property.GuiIds

fun InventoryType.toArchetype(): InventoryArchetype =
    when (this) {
        InventoryType.ANVIL -> InventoryArchetypes.ANVIL
        InventoryType.BEACON -> InventoryArchetypes.BEACON
        InventoryType.BREWING -> InventoryArchetypes.BREWING_STAND
        InventoryType.CHEST -> InventoryArchetypes.CHEST
        InventoryType.CRAFTING -> InventoryArchetypes.CRAFTING
        InventoryType.CREATIVE -> InventoryArchetypes.PLAYER
        InventoryType.DISPENSER -> InventoryArchetypes.DISPENSER
        InventoryType.DROPPER -> InventoryArchetypes.DISPENSER
        InventoryType.ENCHANTING -> InventoryArchetypes.ENCHANTING_TABLE
        InventoryType.ENDER_CHEST -> InventoryArchetypes.CHEST
        InventoryType.FURNACE -> InventoryArchetypes.FURNACE
        InventoryType.HOPPER -> InventoryArchetypes.HOPPER
        InventoryType.MERCHANT -> InventoryArchetypes.VILLAGER
        InventoryType.PLAYER -> InventoryArchetypes.PLAYER
        InventoryType.SHULKER_BOX -> InventoryArchetypes.CHEST
        InventoryType.WORKBENCH -> InventoryArchetypes.CRAFTING
    }

fun InventoryType.toGuiId(): GuiId? =
        when(this) {
            InventoryType.WORKBENCH -> GuiIds.CRAFTING_TABLE
            InventoryType.SHULKER_BOX -> GuiIds.SHULKER_BOX
            InventoryType.PLAYER -> null
            InventoryType.MERCHANT -> GuiIds.VILLAGER
            InventoryType.HOPPER -> GuiIds.HOPPER
            InventoryType.FURNACE -> GuiIds.FURNACE
            InventoryType.ENDER_CHEST -> GuiIds.CHEST
            InventoryType.ENCHANTING -> GuiIds.ENCHANTING_TABLE
            InventoryType.DROPPER -> GuiIds.DISPENSER
            InventoryType.DISPENSER -> GuiIds.DISPENSER
            InventoryType.CREATIVE -> null
            InventoryType.CRAFTING -> GuiIds.CRAFTING_TABLE
            InventoryType.CHEST -> GuiIds.CHEST
            InventoryType.BREWING -> GuiIds.BREWING_STAND
            InventoryType.BEACON -> GuiIds.BEACON
            InventoryType.ANVIL -> GuiIds.ANVIL
        }