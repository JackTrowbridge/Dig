package dev.jacktrowbridge.dig.players

data class DPlayer(

    val uuid: String,
    val lastKnownUsername: String

){

    var isOnline: Boolean = false

    var xp: Int = 0
    var level: Int = 1
    var rawBlocksMined: Int = 0


}
