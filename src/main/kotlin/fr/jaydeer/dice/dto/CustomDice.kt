package fr.jaydeer.dice.dto

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.dice.entity.DiceEntity

data class CustomDice(val id: String?,
                      val faces: Map<String, Int>?): Entitiable<DiceEntity> {

    constructor(faces: Map<String, Int>) : this(null, faces)
    constructor(id: String) : this(id, null)

    override fun toEntity(): DiceEntity = DiceEntity(id!!, faces!!)
}