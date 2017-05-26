package fr.jaydeer.chat

import fr.jaydeer.chat.instance.ChatInstance
import fr.jaydeer.chat.message.ChatMessage
import fr.jaydeer.chat.room.ChatRoom
import fr.jaydeer.chat.speaker.ChatSpeaker
import org.bson.types.ObjectId

interface Chat {
    val instance: ChatInstance

    fun sendMessage(message: ChatMessage, room: ChatRoom? = null, speaker: ChatSpeaker? = null)
    fun createSpeaker(speaker: ChatSpeaker)
    fun deleteSpeaker(speakerId: Any)
    fun createRoom(room: ChatRoom)
    fun addSpeakers(room: ChatRoom, vararg speakers: ChatSpeaker)
    fun addSpeaker(room: ChatRoom, speaker: ChatSpeaker) = addSpeakers(room, speaker)
}