package fr.jaydeer.chat.discord.guild

import fr.jaydeer.chat.discord.DiscordEntity
import fr.jaydeer.chat.instance.ChatInstance

interface Guild: DiscordEntity {

    data class Id(override val entity: Long) : DiscordEntity.Id
}