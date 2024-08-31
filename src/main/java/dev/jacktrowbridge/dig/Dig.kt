package dev.jacktrowbridge.dig

import dev.jacktrowbridge.dig.mining.events.BlockMiningEvent
import dev.jacktrowbridge.dig.players.PlayerManager
import dev.jacktrowbridge.dig.server.events.PlayerConnectEvent
import dev.jacktrowbridge.dig.server.events.PlayerDisconnectEvent
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandAPIConfig
import dev.jorel.commandapi.executors.CommandExecutor
import dev.jorel.commandapi.executors.PlayerCommandExecutor
import org.bukkit.plugin.java.JavaPlugin

class Dig : JavaPlugin() {

    val playerManager = PlayerManager()

    override fun onEnable() {
        // Plugin startup logic

        CommandAPICommand("test")
            .executesPlayer(PlayerCommandExecutor { player, _ ->
                if(playerManager.getPlayer(player) == null){
                    player.sendMessage("You're not currently registered!")
                    return@PlayerCommandExecutor
                }
                val playerData = playerManager.getDataAsString(playerManager.getPlayer(player)!!)
                player.sendMessage(playerData)
            })
            .register()

        registerEvents()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }


    private fun registerEvents(){
        server.pluginManager.registerEvents(BlockMiningEvent(this), this)
        server.pluginManager.registerEvents(PlayerConnectEvent(this), this)
        server.pluginManager.registerEvents(PlayerDisconnectEvent(this), this)
    }
}
