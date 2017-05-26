package fr.jaydeer.dice.custom

import fr.jaydeer.common.domain.Entity

interface CustomDiceEntity: CustomDice, Entity<CustomDiceEntity.Id> {

    interface Id: Entity.Id {
        val entity: String
    }

    data class SimpleId(override val entity: String): Id
}