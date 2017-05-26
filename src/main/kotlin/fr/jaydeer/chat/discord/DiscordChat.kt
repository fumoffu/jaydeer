package fr.jaydeer.chat.discord

import fr.jaydeer.chat.Chat
import fr.jaydeer.chat.discord.guild.Guild
import fr.jaydeer.chat.discord.guild.GuildDocument
import fr.jaydeer.chat.discord.room.DiscordRoom
import fr.jaydeer.chat.discord.webhook.DiscordWebhook
import fr.jaydeer.chat.discord.webhook.WebhookClient
import fr.jaydeer.chat.message.ChatMessage
import fr.jaydeer.chat.message.TextMessage
import fr.jaydeer.chat.room.ChatRoom
import fr.jaydeer.chat.speaker.ChatSpeaker
import sx.blah.discord.api.IDiscordClient

class DiscordChat(
        override val instance: GuildDocument,
        val discordClient: IDiscordClient,
        val webhookClient: WebhookClient) : Chat {

    override fun sendMessage(message: ChatMessage, room: ChatRoom?, speaker: ChatSpeaker?) {
        val discordRoom = room as? DiscordRoom
        val discordSpeaker= speaker as? DiscordWebhook
        val textMessage = message as TextMessage
        val guild = discordClient.getGuildByID(instance.id.entity)
        val channels = when (discordRoom) {
            null -> guild.channels
            else -> listOf(guild.getChannelByID(discordRoom.id.entity))
        }
        when(discordSpeaker) {
            null -> channels.forEach { it.sendMessage(textMessage.content) }
            else -> channels.forEach { webhookClient.sendMessage(textMessage, discordSpeaker) }
        }
    }

    override fun createSpeaker(speaker: ChatSpeaker) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteSpeaker(speakerId: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createRoom(room: ChatRoom) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addSpeakers(room: ChatRoom, vararg speakers: ChatSpeaker) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}