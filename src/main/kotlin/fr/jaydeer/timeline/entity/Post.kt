package fr.jaydeer.timeline.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = Post.collectionId)
data class Post(
        @Id
        val id: String?,
        val threadId: String,
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
