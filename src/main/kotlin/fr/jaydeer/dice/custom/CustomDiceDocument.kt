package fr.jaydeer.dice.custom

import fr.jaydeer.common.domain.Stored
import fr.jaydeer.dice.face.StringFace
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = CustomDiceDocument.collectionId)
data class CustomDiceDocument(
        @Id override val storageId: ObjectId?,
        @Indexed(unique = true) override val id: CustomDiceEntity.SimpleId,
        override val faces: Map<StringFace, Int>): CustomDiceEntity, Stored {
    companion object {
        const val collectionId = "dices"
    }
}