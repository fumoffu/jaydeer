package fr.jaydeer.chat.discord

import fr.jaydeer.chat.Chat
import fr.jaydeer.chat.Room
import fr.jaydeer.chat.actor.Actor
import fr.jaydeer.chat.message.Message
import fr.jaydeer.chat.message.TextMessage
import sx.blah.discord.api.IDiscordClient

class DiscordChat(
        val guildId: Long,
        val discordClient: IDiscordClient,
        val webhookClient: DiscordWebhookClient): Chat {
    override fun sendMessage(message: Message, room: Room, sender: Actor) {
        if(room !is DiscordRoom) throw IllegalArgumentException("Room [$room] must be a DiscordRoom")
        if(sender !is DiscordActor) throw IllegalArgumentException("Sender [$sender] must be a DiscordActor")
        val guild = discordClient.getGuildByID(guildId)
        val channel = guild.getChannelByID(room.id)
        when {
            message is TextMessage && sender is DiscordBot ->
                channel.sendMessage(message.content)
            message is TextMessage && sender is DiscordWebhook ->
                webhookClient.sendMessage(channel.webhooks.first(), message.content, sender)
        }
    }

    override fun createActor(actor: Actor) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteActor(actor: Actor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}