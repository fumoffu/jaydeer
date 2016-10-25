package fr.jaydeer.timeline.dto

import fr.jaydeer.timeline.entity.ThreadEntity
import fr.jaydeer.configuration.TypeCategory
import fr.jaydeer.common.validation.ExistingId
import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.common.validation.ExistingType
import fr.jaydeer.timeline.entity.PostEntity
import javax.validation.constraints.NotNull

data class NewPost(
        @get:NotNull
        @get:ExistingId(ThreadEntity::class)
        val threadId: String,
        @get:NotNull
        @get:ExistingType(TypeCategory.POST)
        val typeId: String,
        val content: Any): Entitiable<PostEntity> {

    override fun toEntity() = PostEntity(threadId, typeId, content)
}