package fr.jaydeer.chat.instance

import fr.jaydeer.chat.ChatEntity

interface ChatInstance : ChatEntity {
    override val id: Id
    interface Id : ChatEntity.Id
}