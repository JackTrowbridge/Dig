package dev.jacktrowbridge.dig.server.events

import dev.jacktrowbridge.dig.Dig
import dev.jacktrowbridge.dig.players.DPlayer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerConnectEvent(private val plugin: Dig) : Listener{
    @EventHandler
    fun onPlayerConnect(event: PlayerJoinEvent){
        val player = event.player
        var dPlayer = plugin.playerManager.getPlayer(player)
        if(dPlayer == null){
            // Create new dPlayer
            val newDPlayer = DPlayer(
                lastKnownUsername = player.name,
                uuid = player.uniqueId.toString(),
            )
            dPlayer = newDPlayer
            plugin.playerManager.addPlayer(dPlayer)
        }
        dPlayer.isOnline = true
    }
}
