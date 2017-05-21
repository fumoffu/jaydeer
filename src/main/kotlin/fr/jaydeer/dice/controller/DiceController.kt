package fr.jaydeer.dice.controller

import fr.jaydeer.common.api.validation.groups.Creation
import fr.jaydeer.common.controller.toResponse
import fr.jaydeer.dice.dto.CustomDice
import fr.jaydeer.dice.dto.Dice
import fr.jaydeer.dice.dto.Face
import fr.jaydeer.dice.service.DiceService
import fr.jaydeer.dice.service.RollService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
class DiceController(
        val rollService: RollService,
        val diceService: DiceService) {

    @RequestMapping(value = "/roll", method = arrayOf(RequestMethod.POST))
    fun roll(@RequestBody dices: Array<Dice>): List<Face> {
        return rollService.roll(*dices)
    }

    @RequestMapping(value = "/dices", method = arrayOf(RequestMethod.POST))
    fun createCustomDice(@Validated(Creation::class) @RequestBody dice: CustomDice): CustomDice {
        return diceService.save(dice)
    }

    @RequestMapping(value = "/dices/{id}", method = arrayOf(RequestMethod.GET))
    fun getCustomDice(@PathVariable id: String): ResponseEntity<CustomDice> {
        return diceService.find(id).toResponse()
    }
}