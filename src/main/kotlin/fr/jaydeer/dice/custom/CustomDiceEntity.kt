package fr.jaydeer.dice.custom

import fr.jaydeer.common.domain.Entity

interface CustomDiceEntity: CustomDice, Entity{
    override val id: Id

    data class Id(val entity: String)
}