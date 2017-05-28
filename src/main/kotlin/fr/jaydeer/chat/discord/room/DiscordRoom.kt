package fr.jaydeer.chat.discord.room

import fr.jaydeer.chat.discord.DiscordEntity
import fr.jaydeer.chat.discord.webhook.DiscordWebhook
import fr.jaydeer.chat.room.ChatRoom

interface DiscordRoom: DiscordEntity, ChatRoom {
    override val id: Id

    data class Id(override val entity: Long) : DiscordEntity.Id, ChatRoom.Id
}