package fr.jaydeer.timeline.entity

import fr.jaydeer.common.validation.ExistingId
import fr.jaydeer.timeline.repository.PostTypeRepository
import fr.jaydeer.timeline.repository.ThreadRepository
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = Post.collectionId)
data class Post(
        @Id
        val id: String?,
        @get:ExistingId(ThreadRepository::class)
        val threadId: String,
        @get:ExistingId(PostTypeRepository::class)
        val typeId: String,
        @CreatedDate
        val createdDate: Instant?,
        val content: Any) {

    constructor(threadId: String,
                typeId: String,
                content: Any) : this(null, threadId, typeId, null, content)

    companion object {
        const val collectionId = "posts"
    }
}
