package gg.rsmod.plugins.content.mechanics.run

on_login {
    player.timers[RunEnergy.RUN_DRAIN] = 1
    if (player.isFirstLogin()) {
        player.setVarp(RunEnergy.RUN_ENABLED_VARP, 1)
    }
}

on_timer(RunEnergy.RUN_DRAIN) {
    player.timers[RunEnergy.RUN_DRAIN] = 1
    RunEnergy.drain(player)
}

on_timer(RunEnergyDrain.DRAIN_INCREASE_TIMER) {
    player.attr.remove(RunEnergyDrain.DRAIN_INCREASE_ATTRIBUTE)
}

/**
 * Button by minimap.
 */
on_button(interfaceId = 160, component = 22) {
    RunEnergy.toggle(player)
}

/**
 * Settings button.
 */
on_button(interfaceId = 116, component = 27) {
    RunEnergy.toggle(player)
}