package fr.jaydeer.dice.service

import com.fasterxml.jackson.databind.ObjectMapper
import fr.jaydeer.dice.dto.*
import org.springframework.stereotype.Service
import java.util.*

@Service
open class RollingService(
        val customDiceService: CustomDiceService,
        val objectMapper: ObjectMapper) {

    fun roll(dice: Dice): Face {
        return when(dice.type) {
            DiceType.CUSTOM_DICE_ID -> roll(objectMapper.treeToValue(dice.settings, CustomDice::class.java))
            DiceType.N_SIDED_DICE_ID -> roll(objectMapper.treeToValue(dice.settings, NSidedDice::class.java))
            else -> throw IllegalArgumentException("Unknown type of dice")
        }
    }

    fun roll(vararg dices: Dice): List<Face> = roll(dices.asList())
    fun roll(dices: List<Dice>): List<Face> = dices.map { roll(it) }

    fun roll(dice: NSidedDice): IntFace = IntFace(Random().nextInt(dice.n) * dice.step + dice.start)

    fun roll(dice: CustomDice): Face {
        when {
            dice.faces != null -> return roll(dice.faces)
            dice.id != null -> return roll(dice.id)
            else -> throw IllegalArgumentException("There is no id and no faces to this dice")
        }
    }

    fun roll(diceId: String): Face = roll(customDiceService.findOne(diceId))

    // Exponential distribution
    fun roll(dice: Map<String, Int>): Face = dice
            .map { Pair(it.key, -Math.log(Random().nextDouble()) / it.value) }
            .minBy { it.second }!!.first.toFace()
}