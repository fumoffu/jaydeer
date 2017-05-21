package fr.jaydeer.chat

import fr.jaydeer.chat.actor.Actor
import fr.jaydeer.chat.message.Message

interface Chat {
    fun sendMessage(message: Message, room: Room, sender: Actor)
    fun createActor(actor: Actor)
    fun deleteActor(actor: Actor)
}