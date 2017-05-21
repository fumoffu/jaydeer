package fr.jaydeer.chat.discord

import org.springframework.web.client.RestTemplate
import sx.blah.discord.handle.obj.IWebhook

class DiscordWebhookClient(val client: RestTemplate) {
    val webhookUrl = "https://discordapp.com/api/webhooks"

    fun sendMessage(webhook: IWebhook, content: String, sender: DiscordWebhook) {
        val url = "$webhookUrl/${webhook.stringID}/${webhook.token}"
        client.postForLocation(url, WebhookMessage(content, sender.username, sender.avatarUrl))
    }

    data class WebhookMessage(
            val content: String,
            val username: String,
            val avatar_url: String,
            val tts: Boolean = false)
}