package fr.jaydeer.dice.service

import fr.jaydeer.dice.dto.*
import org.springframework.stereotype.Service
import java.util.*

@Service
class RollService(val diceService: DiceService) {

    fun roll(dice: Dice): Face =  when {
        dice is NSideDice -> RollService.roll(dice)
        dice is CustomDice && dice.faces != null -> roll(dice.faces)
        dice is CustomDice && dice.id != null -> roll(dice.id)
        else -> throw IllegalArgumentException("There is no id and no faces to this faces")
    }

    fun roll(vararg dices: Dice): List<Face> = dices.map { roll(it) }

    fun roll(facesId: String): Face {
        val faces = diceService.find(facesId)
        if (faces != null) {
            return roll(faces)
        } else {
            throw IllegalArgumentException("There is no faces with id [$facesId]")
        }
    }

    companion object {
        fun roll(dice: NSideDice): IntFace = IntFace(Random().nextInt(dice.n) * dice.step + dice.start)

        // Exponential distribution
        fun roll(dice: Map<String, Int>): Face = dice
                .map { Pair(it.key, -Math.log(Random().nextDouble()) / it.value) }
                .minBy { it.second }?.first?.toFace() ?: throw IllegalArgumentException("The dice has no face")
    }
}