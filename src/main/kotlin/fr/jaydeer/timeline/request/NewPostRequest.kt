package fr.jaydeer.timeline.request

import fr.jaydeer.timeline.entity.Thread
import fr.jaydeer.timeline.entity.PostType
import fr.jaydeer.common.validation.ExistingId
import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.timeline.entity.Post
import javax.validation.constraints.NotNull

data class NewPostRequest(
        @get:NotNull
        @get:ExistingId(Thread::class)
        val threadId: String,
        @get:NotNull
        @get:ExistingId(PostType::class)
        val typeId: String,
        val content: Any): Entitiable<Post> {

    override fun toEntity() = Post(threadId, typeId, content)
}