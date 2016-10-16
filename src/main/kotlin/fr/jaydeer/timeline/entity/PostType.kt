package fr.jaydeer.timeline.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = PostType.collectionId)
data class PostType(
        @Id
        val id: String) {

    companion object {
        const val collectionId = "postTypes"
    }
}