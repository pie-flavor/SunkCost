package flavor.pie.sunkcost.inventory

import org.bukkit.inventory.ItemStack
import org.spongepowered.api.item.inventory.ItemStack as SItemStack

class SunkItemStack(val stack: SItemStack) : ItemStack() {

    companion object {
        operator fun invoke(stack: ItemStack): SunkItemStack =
            if (stack is SunkItemStack) {
                stack
            } else {
                SunkItemStack(stack.toSponge())
            }
        private fun ItemStack.toSponge(): SItemStack {
            TODO()
        }
    }


}
