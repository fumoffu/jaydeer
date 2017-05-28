package fr.jaydeer.chat.speaker

import fr.jaydeer.chat.ChatEntity

interface ChatSpeaker : ChatEntity {
    override val id: ChatSpeaker.Id
    interface Id : ChatEntity.Id
}