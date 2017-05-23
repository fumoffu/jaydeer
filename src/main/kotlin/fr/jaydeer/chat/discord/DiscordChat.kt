package fr.jaydeer.chat.discord

import fr.jaydeer.chat.Chat
import fr.jaydeer.chat.discord.speaker.DiscordWebhook
import fr.jaydeer.chat.message.Message
import fr.jaydeer.chat.message.TextMessage
import fr.jaydeer.chat.room.Room
import fr.jaydeer.chat.server.ServerId
import fr.jaydeer.chat.speaker.Speaker
import fr.jaydeer.chat.speaker.SpeakerId
import sx.blah.discord.api.IDiscordClient

class DiscordChat(
        override val serverId: ServerId,
        val discordClient: IDiscordClient,
        val webhookClient: DiscordWebhookClient) : Chat {

    override fun sendMessage(message: Message, room: Room?, speaker: Speaker?) {
        val guild = discordClient.getGuildByID(serverId.value.toLong())
        val channels = when {
            room == null -> guild.channels
            else -> listOf(guild.getChannelByID(room.id.value.toLong()))
        }
        when {
            message is TextMessage && speaker == null ->
                channels.forEach { it.sendMessage(message.content) }
            message is TextMessage && speaker is DiscordWebhook ->
                channels.forEach { webhookClient.sendMessage(message, speaker) }
            speaker == null -> throw IllegalArgumentException("Message of type [${message::class}] unsupported")
            else -> throw IllegalArgumentException("""Message of type [${message::class}] or speaker of type
            [${speaker::class} unsupported""")
        }
    }

    override fun createSpeaker(speaker: Speaker) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteSpeaker(speakerId: SpeakerId) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createRoom(room: Room) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addSpeakers(room: Room, vararg speakers: Speaker) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}