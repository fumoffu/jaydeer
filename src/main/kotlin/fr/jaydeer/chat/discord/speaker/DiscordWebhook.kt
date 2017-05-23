package fr.jaydeer.chat.discord.speaker

import fr.jaydeer.chat.speaker.Speaker
import fr.jaydeer.chat.speaker.SpeakerId

data class DiscordWebhook(override val id: SpeakerId,
                          val username: String,
                          val avatarUrl: String,
                          val token: String): Speaker