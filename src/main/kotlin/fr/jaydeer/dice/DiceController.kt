package fr.jaydeer.dice

import fr.jaydeer.common.api.validation.groups.Creation
import fr.jaydeer.dice.custom.CustomDice
import fr.jaydeer.dice.custom.CustomDiceEntity
import fr.jaydeer.dice.face.Face
import fr.jaydeer.dice.roll.Rollable
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class DiceController(val diceService: DiceService) {

    @RequestMapping(value = "/roll", method = arrayOf(RequestMethod.POST))
    fun rollDices(@RequestBody dices: Array<Rollable>): List<Face> {
        return diceService.roll(*dices)
    }

    @RequestMapping(value = "/dices", method = arrayOf(RequestMethod.POST))
    fun createCustomDice(@Validated(Creation::class) @RequestBody dice: CustomDiceEntity): CustomDice {
        return diceService.createCustomDice(dice)
    }
}