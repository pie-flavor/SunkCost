@file:Suppress("DEPRECATION")

package flavor.pie.sunkcost.inventory

import flavor.pie.kludge.*
import flavor.pie.sunkcost.bLocation
import flavor.pie.sunkcost.slotIndex
import flavor.pie.sunkcost.stringByCode
import flavor.pie.sunkcost.toItemType
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.HumanEntity
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack
import org.spongepowered.api.item.inventory.property.InventoryTitle
import org.spongepowered.api.world.Locatable
import org.spongepowered.api.item.inventory.Inventory as SInventory
import java.util.HashMap
import java.util.Locale

open class SunkInventory(val inventory: SInventory) : Inventory {

    override fun contains(materialId: Int): Boolean {
        val mat = Material.getMaterial(materialId) ?: return false
        return contains(mat)
    }

    override fun contains(material: Material): Boolean {
        val type = material.toItemType() ?: return false
        return inventory.contains(type)
    }

    override fun contains(item: ItemStack): Boolean {
        val stack = SunkItemStack(item).stack
        return inventory.contains(stack)
    }

    override fun contains(materialId: Int, amount: Int): Boolean {
        val mat = Material.getMaterial(materialId) ?: return false
        return contains(mat, amount)
    }

    override fun contains(material: Material, amount: Int): Boolean {
        val type = material.toItemType() ?: return false
        val query = inventory[type]
        for (slot in query.slots) {
            if (slot.totalItems() >= amount) {
                return true
            }
        }
        return false
    }

    override fun contains(item: ItemStack, amount: Int): Boolean {
        val stack = SunkItemStack(item).stack
        val query = inventory[stack]
        return query.size() >= amount
    }

    override fun clear(index: Int) {
        inventory[index]?.clear()
    }

    override fun clear() = inventory.clear()

    override fun containsAtLeast(item: ItemStack, amount: Int): Boolean {
        val stack = SunkItemStack(item).stack
        val query = inventory(stack)
        return query.totalItems() >= amount
    }

    override fun getName(): String {
        return inventory.name[Locale.ENGLISH]
    }

    override fun firstEmpty(): Int {
        for (slot in inventory.slots) {
            if (!slot.peek().isPresent) {
                return slot.slotIndex ?: continue
            }
        }
        return -1
    }

    override fun getSize(): Int = inventory.capacity()

    override fun getItem(index: Int): ItemStack? {
        val stack = inventory(index) ?: return null
        return SunkItemStack(stack)
    }

    override fun addItem(vararg items: ItemStack): HashMap<Int, ItemStack> {
        val map = hashMapOf<Int, ItemStack>()
        for ((idx, item) in items.withIndex()) {
            val stack = SunkItemStack(item).stack
            val result = inventory.offer(stack)
            if (result.rejectedItems.isNotEmpty()) {
                item.amount = stack.quantity
                map[idx] = item
            }
        }
        return map
    }

    override fun all(materialId: Int): HashMap<Int, out ItemStack> {
        val mat = Material.getMaterial(materialId) ?: return hashMapOf()
        return all(mat)
    }

    override fun all(material: Material): HashMap<Int, out ItemStack> {
        val map = hashMapOf<Int, SunkItemStack>()
        val type = material.toItemType() ?: return map
        val query = inventory[type]
        for (slot in query.slots) {
            slot.slotIndex?.let { idx -> slot.peek().unwrap()?.let { map[idx] = SunkItemStack(it) } }
        }
        return map
    }

    override fun all(item: ItemStack): HashMap<Int, out ItemStack> {
        val map = hashMapOf<Int, SunkItemStack>()
        val stack = SunkItemStack(item).stack
        val query = inventory[stack]
        for (slot in query.slots) {
            slot.slotIndex?.let { idx -> slot.peek().unwrap()?.let { map[idx] = SunkItemStack(it) } }
        }
        return map
    }

    override fun iterator(): MutableListIterator<ItemStack> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(index: Int): MutableListIterator<ItemStack> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContents(): Array<out ItemStack> =
        inventory.slots.mapNotNull { s -> s.peek().unwrap()?.let { SunkItemStack(it) } }.toTypedArray()

    override fun setContents(items: Array<out ItemStack>) {
        if (items.size > inventory.capacity()) {
            throw IllegalArgumentException("items")
        }
        inventory.clear()
        for (item in items) {
            inventory += SunkItemStack(item).stack
        }
    }

    override fun getTitle(): String =
        inventory.getInventoryProperty(InventoryTitle::class.java).unwrap()?.value?.stringByCode()
            ?: inventory.name[Locale.ENGLISH]

    override fun first(materialId: Int): Int {
        val mat = Material.getMaterial(materialId) ?: return -1
        return first(mat)
    }

    override fun first(material: Material): Int {
        val type = material.toItemType() ?: return -1
        val query = inventory[type]
        return query.slots.asSequence().map { it.slotIndex }.firstOrNull() ?: -1
    }

    override fun first(item: ItemStack): Int {
        val stack = SunkItemStack(item).stack
        val query = inventory[stack]
        return query.slots.asSequence().map { it.slotIndex }.firstOrNull() ?: -1
    }

    override fun getViewers(): MutableList<HumanEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setItem(index: Int, item: ItemStack?) {
        if (item == null) {
            inventory[index]?.clear()
        } else {
            inventory[index] = SunkItemStack(item).stack
        }
    }

    override fun removeItem(vararg items: ItemStack?): HashMap<Int, ItemStack> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocation(): Location? = ((holder as? SunkInventoryHolder)?.carrier as? Locatable)?.location?.bLocation()

    override fun getStorageContents(): Array<out ItemStack> = this.contents

    override fun remove(materialId: Int) {
        val mat = Material.getMaterial(materialId) ?: return
        remove(mat)
    }

    override fun remove(material: Material) {
        val type = material.toItemType() ?: return
        val query = inventory[type]
        query.clear()
    }

    override fun remove(item: ItemStack) {
        val stack = SunkItemStack(item).stack
        val query = inventory[stack]
        query.clear()
    }

    override fun getType(): InventoryType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStorageContents(items: Array<out ItemStack>) {
        contents = items
    }

    override fun setMaxStackSize(size: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMaxStackSize(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHolder(): InventoryHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
