package fr.jaydeer.dice.service

import fr.jaydeer.common.service.CrudService
import fr.jaydeer.dice.dto.CustomDice
import fr.jaydeer.dice.entity.DiceEntity
import fr.jaydeer.dice.repository.DiceRepository
import org.springframework.stereotype.Service

@Service
open class DiceService(repository: DiceRepository):
        CrudService<CustomDice, DiceEntity, String>(repository) {
}