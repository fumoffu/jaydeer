package fr.jaydeer.chat.discord.guild

import org.bson.types.ObjectId

data class GuildDocument(override val id: Guild.Id, override val storageId: ObjectId?) : Guild