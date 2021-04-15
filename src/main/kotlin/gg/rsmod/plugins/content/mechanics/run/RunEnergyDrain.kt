package gg.rsmod.plugins.content.mechanics.run

import gg.rsmod.game.model.attr.AttributeKey
import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.model.timer.TimerKey

object RunEnergyDrain {

    val DRAIN_INCREASE_TIMER = TimerKey()
    val DRAIN_INCREASE_ATTRIBUTE = AttributeKey<Double>()

    /**
     * Sets the drain factor.
     * @param factor The drain factory, 1.5 would be 50% increased drain.
     * @param cycles The amount of cycles this increased drain will continue.
     */
    fun setDrainFactor(p: Player, factor: Double, cycles: Int) {
        p.attr[DRAIN_INCREASE_ATTRIBUTE] = factor
        p.timers[DRAIN_INCREASE_TIMER] = cycles
    }

    fun getDrainFactor(p: Player): Double {
        return p.attr.getOrDefault(DRAIN_INCREASE_ATTRIBUTE, 1.0)
    }

}