package fr.jaydeer.dice.dto

import com.fasterxml.jackson.annotation.JsonValue

enum class DiceType(val id: String) {
    N_SIDE(Id.N_SIDE),
    CUSTOM(Id.CUSTOM);

    @JsonValue
    override fun toString(): String {
        return id
    }

    companion object {
        fun forValue(id: String): DiceType = DiceType.values().first { it.id == id }
    }

    object Id {
        const val N_SIDE = "nSide"
        const val CUSTOM = "custom"
    }
}