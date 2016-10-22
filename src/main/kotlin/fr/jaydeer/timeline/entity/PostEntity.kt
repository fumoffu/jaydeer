package fr.jaydeer.timeline.entity

import fr.jaydeer.common.conversion.Transferable
import fr.jaydeer.timeline.dto.Post
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = PostEntity.collectionId)
class PostEntity() : Transferable<Post> {

    @Id
    var id: String? = null
    lateinit var threadId: String
    lateinit var typeId: String
    @CreatedDate
    var createdDate: Instant? = null
    lateinit var content: Any

    constructor(threadId: String,
                typeId: String,
                content: Any) : this() {
        this.threadId = threadId
        this.typeId = typeId
        this.content = content
    }

    constructor(id: String,
                threadId: String,
                typeId: String,
                createdDate: Instant,
                content: Any) : this(threadId, typeId, content) {
        this.id = id
        this.createdDate = createdDate
    }

    override fun toDTO(): Post = Post(id!!, threadId, typeId, createdDate!!, content)

    companion object {
        const val collectionId = "posts"
    }
}
