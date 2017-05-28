package fr.jaydeer.chat.discord

import fr.jaydeer.chat.ChatEntity
import fr.jaydeer.chat.instance.InstanceProvider

interface DiscordEntity : ChatEntity {
    override val id: Id

    interface Id : ChatEntity.Id {
        override val entity: Long
        override val provider: InstanceProvider
            get() = DISCORD
    }

    companion object {
        val DISCORD = InstanceProvider("DISCORD")
    }
}