package fr.jaydeer.timeline.dto

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.timeline.entity.PostEntity
import java.time.Instant

data class Post(val id: String,
                val threadId: String,
                val typeId: String,
                val createdDate: Instant,
                val content: Any): Entitiable<PostEntity> {
    override fun toEntity(): PostEntity =
            PostEntity(id, threadId, typeId, createdDate, content)
}