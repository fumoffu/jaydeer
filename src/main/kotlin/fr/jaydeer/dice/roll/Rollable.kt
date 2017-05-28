package fr.jaydeer.dice.roll

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import fr.jaydeer.dice.custom.CustomDice
import fr.jaydeer.dice.face.IntFace
import fr.jaydeer.dice.face.StringFace
import fr.jaydeer.dice.nside.IntDice

@JsonDeserialize(using = RollableDeserializer::class)
sealed class Rollable

@JsonDeserialize(`as` = CustomDiceRoll::class)
data class CustomDiceRoll(override val faces: Map<StringFace, Int>) : CustomDice, Rollable()

@JsonDeserialize(`as` = IntDiceRoll::class)
data class IntDiceRoll(override val n: Int, override val start: Int = 1, override val step: Int = 1) : IntDice, Rollable() {
    override val faces: Map<IntFace, Int>
        @JsonIgnore
        get() = super.faces
}

@JsonDeserialize(`as` = IdRoll::class)
data class IdRoll(val id: String) : Rollable()