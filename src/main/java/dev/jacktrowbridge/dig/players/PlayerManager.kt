package dev.jacktrowbridge.dig.players

import org.bukkit.entity.Player

class PlayerManager {

    private val players: MutableList<DPlayer> = mutableListOf()

    fun getPlayer(uuid: String): DPlayer? {
        return players.find { it.uuid == uuid }
    }
    fun getPlayer(player: Player): DPlayer? {
        return players.find { it.uuid == player.uniqueId.toString() }
    }

    fun addPlayer(player: DPlayer) {
        players.add(player)
    }

    fun removePlayer(player: DPlayer) {
        players.remove(player)
    }

    fun getAllPlayers(): List<DPlayer> {
        return players
    }

    fun getOnlinePlayers(): List<DPlayer> {
        return players.filter { it.isOnline }
    }

    fun getOfflinePlayers(): List<DPlayer> {
        return players.filter { !it.isOnline }
    }

    fun getDataAsString(player: DPlayer): String {
        return "UUID: ${player.uuid}, Name: ${player.lastKnownUsername}, Online: ${player.isOnline}, Blocks Broken: ${player.rawBlocksMined}, XP: ${player.xp}, Level: ${player.level}"
    }

}