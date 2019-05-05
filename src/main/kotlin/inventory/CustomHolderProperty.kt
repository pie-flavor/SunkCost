package flavor.pie.sunkcost.inventory

import org.bukkit.inventory.InventoryHolder
import org.spongepowered.api.data.Property
import org.spongepowered.api.item.inventory.property.AbstractInventoryProperty

class CustomHolderProperty(val holder: InventoryHolder) : AbstractInventoryProperty<String, InventoryHolder>(holder) {

    override fun compareTo(other: Property<*, *>?): Int {
        return if (other !is CustomHolderProperty) {
            -1
        } else {
            this.hashCode().compareTo(other.hashCode())
        }
    }
}