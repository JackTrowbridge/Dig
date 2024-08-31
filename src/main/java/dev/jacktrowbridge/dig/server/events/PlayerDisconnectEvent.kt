package dev.jacktrowbridge.dig.server.events

import dev.jacktrowbridge.dig.Dig
import dev.jacktrowbridge.dig.players.DPlayer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerDisconnectEvent(private val plugin: Dig) : Listener{
    @EventHandler
    fun onPlayerDisconnect(event: PlayerQuitEvent){
        val player = event.player
        val dPlayer = plugin.playerManager.getPlayer(player) ?: return
        dPlayer.isOnline = false
    }
}
