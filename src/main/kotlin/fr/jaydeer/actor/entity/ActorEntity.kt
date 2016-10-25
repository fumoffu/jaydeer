package fr.jaydeer.actor.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = ActorEntity.collectionId)
class ActorEntity {

    @Id
    var id: String? = null
    lateinit var name: String
    lateinit var typeId: String
    var pictureId: String? = null

    companion object {
        const val collectionId = "actors"
    }
}