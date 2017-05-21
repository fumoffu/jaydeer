package fr.jaydeer.dice.entity

import fr.jaydeer.common.domain.Entity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = DiceEntity.collectionId)
data class DiceEntity(@Id override val id: String, val faces: Map<String, Int>): Entity {
    companion object {
        const val collectionId = "dices"
    }
}