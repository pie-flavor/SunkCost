package flavor.pie.sunkcost.entity

import org.bukkit.entity.AbstractHorse
import org.bukkit.entity.Horse
import org.spongepowered.api.entity.living.animal.Animal

abstract class SunkAbstractHorse(entity: Animal) : SunkTameable(entity), AbstractHorse {

    override fun setDomestication(level: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJumpStrength(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDomestication(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setJumpStrength(strength: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setVariant(variant: Horse.Variant?) {
        throw UnsupportedOperationException("variants")
    }

    override fun getMaxDomestication(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVariant(): Horse.Variant {
        throw UnsupportedOperationException("variants")
    }

    override fun setMaxDomestication(level: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}