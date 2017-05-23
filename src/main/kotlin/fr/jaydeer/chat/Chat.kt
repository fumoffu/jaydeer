package fr.jaydeer.chat

import fr.jaydeer.chat.message.Message
import fr.jaydeer.chat.room.Room
import fr.jaydeer.chat.server.ServerId
import fr.jaydeer.chat.speaker.Speaker
import fr.jaydeer.chat.speaker.SpeakerId

interface Chat {
    val serverId: ServerId

    fun sendMessage(message: Message, room: Room? = null, speaker: Speaker? = null)
    fun createSpeaker(speaker: Speaker)
    fun deleteSpeaker(speakerId: SpeakerId)
    fun createRoom(room: Room)
    fun addSpeakers(room: Room, vararg speakers: Speaker)
    fun addSpeaker(room: Room, speaker: Speaker) = addSpeakers(room, speaker)
}