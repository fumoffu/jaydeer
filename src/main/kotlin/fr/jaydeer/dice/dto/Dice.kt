package fr.jaydeer.dice.dto

import com.fasterxml.jackson.databind.JsonNode

data class Dice(
        val type: DiceType,
        val settings: JsonNode) {
}