package fr.jaydeer.chat.service

import fr.jaydeer.chat.Chat
import fr.jaydeer.chat.discord.DiscordChat
import fr.jaydeer.chat.discord.DiscordWebhookClient
import fr.jaydeer.chat.server.ServerId
import fr.jaydeer.chat.server.ServerProvider
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import sx.blah.discord.api.IDiscordClient

@Service
class ChatService(val discordClient: Mono<IDiscordClient>,
                  val webhookClient: DiscordWebhookClient) {

    fun chat(serverId: ServerId): Mono<Chat> {
        return when (serverId.provider) {
            ServerProvider.DISCORD -> discordClient.map { DiscordChat(serverId, it, webhookClient)  }
        }
    }
}