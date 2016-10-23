package fr.jaydeer.dice.controller

import fr.jaydeer.dice.dto.CustomDice
import fr.jaydeer.dice.dto.Dice
import fr.jaydeer.dice.dto.Face
import fr.jaydeer.dice.service.CustomDiceService
import fr.jaydeer.dice.service.RollingService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
open class DiceController(
        val rollingService: RollingService,
        val customDiceService: CustomDiceService) {

    @RequestMapping(value="/roll", method = arrayOf(RequestMethod.POST))
    fun roll(@RequestBody @Valid dices: List<Dice>): List<Face> {
        return rollingService.roll(dices)
    }

    @RequestMapping(value="/dices", method = arrayOf(RequestMethod.POST))
    fun newDice(@RequestBody @Valid dice: CustomDice): CustomDice {
        return customDiceService.save(dice)
    }
}