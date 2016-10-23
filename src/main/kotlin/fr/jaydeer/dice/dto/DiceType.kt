package fr.jaydeer.dice.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import fr.jaydeer.dice.deserializer.DiceTypeDeserializer

@JsonDeserialize(using = DiceTypeDeserializer::class)
enum class DiceType(val type: String) {
    N_SIDED_DICE_ID("nSided"),
    CUSTOM_DICE_ID("custom");

    companion object {
        fun forValue(type: String): DiceType = DiceType.values().first { it.type == type }
    }
}