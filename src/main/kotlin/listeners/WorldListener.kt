package flavor.pie.sunkcost.listeners

import flavor.pie.kludge.*
import org.spongepowered.api.entity.weather.Lightning
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.Order
import org.spongepowered.api.event.entity.DamageEntityEvent
import org.spongepowered.api.event.filter.cause.First
import java.util.UUID

object WorldListener {

    private val lightning: MutableSet<UUID> = mutableSetOf()

    fun addLightningEffect(uuid: UUID) {
        lightning += uuid
        delay(40) {
            lightning -= uuid
        }
    }

    @Listener(order = Order.PRE, beforeModifications = true)
    fun onLightningStrike(e: DamageEntityEvent, @First lightning: Lightning) {
        if (lightning.uniqueId in this.lightning) {
            e.isCancelled = true
        }
    }
}