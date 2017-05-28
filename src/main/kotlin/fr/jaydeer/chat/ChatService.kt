package fr.jaydeer.chat

import fr.jaydeer.chat.discord.DiscordChat
import fr.jaydeer.chat.discord.guild.Guild
import fr.jaydeer.chat.discord.guild.GuildDocument
import fr.jaydeer.chat.discord.webhook.WebhookClient
import fr.jaydeer.chat.instance.ChatInstance
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import sx.blah.discord.api.IDiscordClient

@Service
class ChatService(val discordClient: Mono<IDiscordClient>,
                  val webhookClient: WebhookClient) {

    fun chat(id: ChatInstance.Id): Mono<Chat> {
        return discordClient.map { DiscordChat(GuildDocument(id as Guild.Id, ObjectId()), it, webhookClient)  }
    }
}