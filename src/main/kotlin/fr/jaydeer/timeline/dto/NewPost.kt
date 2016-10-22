package fr.jaydeer.timeline.dto

import fr.jaydeer.timeline.entity.ThreadEntity
import fr.jaydeer.timeline.entity.PostTypeEntity
import fr.jaydeer.common.validation.ExistingId
import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.timeline.entity.PostEntity
import javax.validation.constraints.NotNull

data class NewPost(
        @get:NotNull
        @get:ExistingId(ThreadEntity::class)
        val threadId: String,
        @get:NotNull
        @get:ExistingId(PostTypeEntity::class)
        val typeId: String,
        val content: Any): Entitiable<PostEntity> {

    override fun toEntity() = PostEntity(threadId, typeId, content)
}