package flavor.pie.sunkcost.inventory

import org.bukkit.event.inventory.InventoryType
import org.spongepowered.api.item.inventory.InventoryArchetype
import org.spongepowered.api.item.inventory.InventoryArchetypes
import org.spongepowered.api.item.inventory.property.GuiId
import org.spongepowered.api.item.inventory.property.GuiIds

private val archetypeMap: Map<InventoryType, InventoryArchetype> = mapOf(
    InventoryType.ANVIL to InventoryArchetypes.ANVIL,
    InventoryType.BEACON to InventoryArchetypes.BEACON,
    InventoryType.BREWING to InventoryArchetypes.BREWING_STAND,
    InventoryType.CHEST to InventoryArchetypes.CHEST,
    InventoryType.CRAFTING to InventoryArchetypes.CRAFTING,
    InventoryType.CREATIVE to InventoryArchetypes.PLAYER,
    InventoryType.DISPENSER to InventoryArchetypes.DISPENSER,
    InventoryType.DROPPER to InventoryArchetypes.DISPENSER,
    InventoryType.ENCHANTING to InventoryArchetypes.ENCHANTING_TABLE,
    InventoryType.ENDER_CHEST to InventoryArchetypes.CHEST,
    InventoryType.FURNACE to InventoryArchetypes.FURNACE,
    InventoryType.HOPPER to InventoryArchetypes.HOPPER,
    InventoryType.MERCHANT to InventoryArchetypes.VILLAGER,
    InventoryType.PLAYER to InventoryArchetypes.PLAYER,
    InventoryType.SHULKER_BOX to InventoryArchetypes.CHEST,
    InventoryType.WORKBENCH to InventoryArchetypes.CRAFTING
)

fun InventoryType.toArchetype(): InventoryArchetype = archetypeMap.getValue(this)

private val guiIdMap: Map<InventoryType, GuiId> = mapOf(
    InventoryType.WORKBENCH to GuiIds.CRAFTING_TABLE,
    InventoryType.SHULKER_BOX to GuiIds.SHULKER_BOX,
//    InventoryType.PLAYER to null,
    InventoryType.MERCHANT to GuiIds.VILLAGER,
    InventoryType.HOPPER to GuiIds.HOPPER,
    InventoryType.FURNACE to GuiIds.FURNACE,
    InventoryType.ENDER_CHEST to GuiIds.CHEST,
    InventoryType.ENCHANTING to GuiIds.ENCHANTING_TABLE,
    InventoryType.DROPPER to GuiIds.DISPENSER,
    InventoryType.DISPENSER to GuiIds.DISPENSER,
//    InventoryType.CREATIVE to null,
    InventoryType.CRAFTING to GuiIds.CRAFTING_TABLE,
    InventoryType.CHEST to GuiIds.CHEST,
    InventoryType.BREWING to GuiIds.BREWING_STAND,
    InventoryType.BEACON to GuiIds.BEACON,
    InventoryType.ANVIL to GuiIds.ANVIL
)

fun InventoryType.toGuiId(): GuiId? = guiIdMap[this]