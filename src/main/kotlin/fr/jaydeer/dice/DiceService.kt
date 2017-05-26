package fr.jaydeer.dice

import fr.jaydeer.dice.custom.CustomDice
import fr.jaydeer.dice.custom.CustomDiceEntity
import fr.jaydeer.dice.custom.CustomDiceRepository
import fr.jaydeer.dice.face.Face
import fr.jaydeer.dice.face.IntFace
import fr.jaydeer.dice.nside.NSideDice
import fr.jaydeer.dice.roll.CustomDiceRoll
import fr.jaydeer.dice.roll.CustomDiceIdRoll
import fr.jaydeer.dice.roll.DiceRoll
import fr.jaydeer.dice.roll.NSideDiceRoll
import org.springframework.stereotype.Service
import java.util.*

@Service
class DiceService(val repository: CustomDiceRepository) {

    fun create(dice: CustomDiceEntity): CustomDiceEntity {
        if(repository.existsById(dice.id)) {
            throw IllegalArgumentException("Dice [${dice.id}] exists")
        }
        return repository.save(dice)
    }

    fun roll(dice: DiceRoll): Face = when (dice) {
        is NSideDiceRoll -> roll(dice as NSideDice)
        is CustomDiceIdRoll -> roll(dice as CustomDiceEntity.Id)
        is CustomDiceRoll -> roll(dice as CustomDice)
    }

    fun roll(vararg dices: DiceRoll): List<Face> = dices.map { roll(it) }

    private fun roll(id: CustomDiceEntity.Id): Face {
        val dice = repository.findById(id)
                .orElseThrow { IllegalArgumentException("There is no faces with entityId [$id]") }
        return roll(dice)
    }

    companion object {
        fun roll(dice: NSideDice): IntFace = IntFace(Random().nextInt(dice.n) * dice.step + dice.start)

        // Exponential distribution
        fun roll(dice: Dice): Face = dice.faces
                .map { Pair(it.key, -Math.log(Random().nextDouble()) / it.value) }
                .minBy { it.second }?.first ?: throw IllegalArgumentException("The dice has no face")
    }
}