package fr.jaydeer.chat.discord.webhook

import fr.jaydeer.chat.message.TextMessage
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WebhookClient(val client: RestTemplate = RestTemplate()) {
    val webhookUrl = "https://discordapp.com/api/webhooks"

    fun sendMessage(message: TextMessage, webhook: DiscordWebhook) {
        val url = "$webhookUrl/${webhook.id.entity}/${webhook.token}"
        client.postForLocation(url, WebhookMessage(message.content, webhook.username, webhook.avatarUrl))
    }

    data class WebhookMessage(
            val content: String,
            val username: String,
            val avatar_url: String,
            val tts: Boolean = false)
}