package fr.jaydeer.dice.roll

import fr.jaydeer.dice.custom.CustomDice
import fr.jaydeer.dice.custom.CustomDiceEntity
import fr.jaydeer.dice.face.StringFace
import fr.jaydeer.dice.nside.NSideDice

sealed class DiceRoll

data class CustomDiceRoll(override val faces: Map<StringFace, Int> ): CustomDice, DiceRoll()

data class NSideDiceRoll(override val n: Int, override val start: Int, override val step: Int): NSideDice, DiceRoll()

data class CustomDiceIdRoll(override val entity: String): CustomDiceEntity.Id, DiceRoll()