package fr.jaydeer.chat.discord

import fr.jaydeer.chat.instance.ChatEntity
import fr.jaydeer.chat.instance.InstanceProvider
import fr.jaydeer.chat.instance.SimpleInstanceProvider

interface DiscordEntity : ChatEntity<ChatEntity.Id<Long>> {
    interface Id : ChatEntity.Id<Long> {
        override val provider: InstanceProvider
            get() = DISCORD
    }

    companion object {
        val DISCORD = SimpleInstanceProvider("DISCORD")
    }
}