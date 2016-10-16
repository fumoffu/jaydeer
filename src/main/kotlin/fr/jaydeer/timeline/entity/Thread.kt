package fr.jaydeer.timeline.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = Thread.collectionId)
data class Thread(
        @Id
        val id: String?,
        val name: String) {

    constructor(name: String) : this(null, name)

    companion object {
        const val collectionId = "threads"
    }
}