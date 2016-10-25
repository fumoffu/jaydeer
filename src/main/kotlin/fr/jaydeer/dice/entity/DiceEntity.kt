package fr.jaydeer.dice.entity

import fr.jaydeer.common.conversion.Transferable
import fr.jaydeer.dice.dto.CustomDice
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = DiceEntity.collectionId)
class DiceEntity : Transferable<CustomDice> {

    @Id
    lateinit var id: String
    lateinit var faces: Map<String, Int>

    constructor(id: String, faces: Map<String, Int>): super() {
        this.id = id
        this.faces = faces
    }

    override fun toDTO(): CustomDice = CustomDice(id, faces)

    companion object {
        const val collectionId = "dices"
    }
}