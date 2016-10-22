package fr.jaydeer.timeline.entity

import fr.jaydeer.common.conversion.Transferable
import fr.jaydeer.timeline.dto.PostType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = PostTypeEntity.collectionId)
class PostTypeEntity(): Transferable<PostType> {

    @Id
    lateinit var id: String

    constructor(id: String): this() {
        this.id = id
    }

    override fun toDTO(): PostType = PostType(id)

    companion object {
        const val collectionId = "postTypes"
    }
}