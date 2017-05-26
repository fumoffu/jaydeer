package fr.jaydeer.chat.discord.guild

import fr.jaydeer.chat.instance.ChatEntity
import fr.jaydeer.chat.instance.ChatInstance
import org.bson.types.ObjectId

data class GuildDocument(override val id: ChatEntity.Id<Long>, override val storageId: ObjectId?) : Guild, ChatInstance