package fr.jaydeer.dice

import fr.jaydeer.dice.custom.CustomDiceEntity
import fr.jaydeer.dice.custom.CustomDiceRepository
import fr.jaydeer.dice.face.Face
import fr.jaydeer.dice.face.IntFace
import fr.jaydeer.dice.nside.IntDice
import fr.jaydeer.dice.roll.CustomDiceRoll
import fr.jaydeer.dice.roll.IdRoll
import fr.jaydeer.dice.roll.IntDiceRoll
import fr.jaydeer.dice.roll.Rollable
import org.springframework.stereotype.Service
import java.util.*

@Service
class DiceService(val repository: CustomDiceRepository) {

    fun createCustomDice(dice: CustomDiceEntity): CustomDiceEntity {
        if (repository.existsEntityById(dice.id)) {
            throw IllegalArgumentException("Dice [${dice.id}] exists")
        }
        return repository.save(dice)
    }

    fun roll(dice: Rollable): Face = when (dice) {
        is IntDiceRoll -> rollIntDice(dice)
        is IdRoll -> rollDiceById(CustomDiceEntity.Id(dice.id))
        is CustomDiceRoll -> rollDice(dice)
    }

    fun roll(vararg dices: Rollable): List<Face> = dices.map { roll(it) }

    private fun rollDiceById(id: CustomDiceEntity.Id): Face {
        val dice = repository.findEntityById(id)
                .orElseThrow { IllegalArgumentException("There is no faces with entityId [$id]") }
        return rollDice(dice)
    }

    companion object {
        fun rollIntDice(dice: IntDice): IntFace = IntFace(Random().nextInt(dice.n) * dice.step + dice.start)

        // Exponential distribution
        fun rollDice(dice: Dice): Face = dice.faces
                .map { Pair(it.key, -Math.log(Random().nextDouble()) / it.value) }
                .minBy { it.second }?.first ?: throw IllegalArgumentException("The dice has no face")
    }
}