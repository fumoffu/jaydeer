package fr.jaydeer.chat.discord.room

import fr.jaydeer.chat.discord.DiscordEntity
import fr.jaydeer.chat.room.ChatRoom

interface DiscordRoom: DiscordEntity, ChatRoom<Long> {
}