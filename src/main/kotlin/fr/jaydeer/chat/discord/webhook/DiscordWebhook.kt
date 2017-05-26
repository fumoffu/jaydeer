package fr.jaydeer.chat.discord.webhook

import fr.jaydeer.chat.discord.DiscordEntity
import fr.jaydeer.chat.speaker.ChatSpeaker

interface DiscordWebhook: ChatSpeaker, DiscordEntity {
    val username: String
    val avatarUrl: String
    val token: String

    data class Id(override val entity: Long): DiscordEntity.Id
}