package fr.jaydeer.chat.discord

import fr.jaydeer.chat.actor.Actor

sealed class DiscordActor: Actor

class DiscordWebhook(val username: String, val avatarUrl: String): DiscordActor()

object DiscordBot: DiscordActor()