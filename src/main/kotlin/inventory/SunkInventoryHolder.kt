package flavor.pie.sunkcost.inventory

import org.bukkit.inventory.InventoryHolder
import org.spongepowered.api.item.inventory.Carrier

interface SunkInventoryHolder : InventoryHolder {

    val carrier: Carrier

}
