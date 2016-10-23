package fr.jaydeer.dice.service

import fr.jaydeer.common.service.CrudService
import fr.jaydeer.dice.dto.CustomDice
import fr.jaydeer.dice.entity.CustomDiceEntity
import fr.jaydeer.dice.repository.CustomDiceRepository
import org.springframework.stereotype.Service

@Service
open class CustomDiceService(repository: CustomDiceRepository):
        CrudService<CustomDice, CustomDiceEntity, String>(repository) {
}