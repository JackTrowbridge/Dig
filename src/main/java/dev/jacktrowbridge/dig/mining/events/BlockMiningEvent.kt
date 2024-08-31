package dev.jacktrowbridge.dig.mining.events

import dev.jacktrowbridge.dig.Dig
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BlockMiningEvent(private val plugin: Dig) : Listener{

    @EventHandler
    fun onBlockMine(event: BlockBreakEvent){
        val player = event.player
        val dPlayer = plugin.playerManager.getPlayer(player) ?: return
        dPlayer.rawBlocksMined++
    }

}