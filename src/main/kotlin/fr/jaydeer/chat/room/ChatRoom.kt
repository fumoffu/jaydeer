package fr.jaydeer.chat.room

import fr.jaydeer.chat.ChatEntity

interface ChatRoom : ChatEntity {
    override val id: ChatRoom.Id
    interface Id : ChatEntity.Id
}