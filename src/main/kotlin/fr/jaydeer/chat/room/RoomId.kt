package fr.jaydeer.chat.room

import fr.jaydeer.chat.server.ServerProvider

data class RoomId(val value: String, val provider: ServerProvider)