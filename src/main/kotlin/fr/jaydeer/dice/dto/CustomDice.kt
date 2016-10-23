package fr.jaydeer.dice.dto

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.dice.entity.CustomDiceEntity

data class CustomDice(val id: String?,
                      val faces: Map<String, Int>?): Entitiable<CustomDiceEntity> {

    constructor(faces: Map<String, Int>) : this(null, faces)
    constructor(id: String) : this(id, null)

    override fun toEntity(): CustomDiceEntity = CustomDiceEntity(id!!, faces!!)
}