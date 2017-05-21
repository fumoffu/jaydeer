package fr.jaydeer.dice.service

import fr.jaydeer.common.service.EntityService
import fr.jaydeer.dice.dto.CustomDice
import fr.jaydeer.dice.entity.DiceEntity
import fr.jaydeer.dice.repository.DiceRepository
import org.springframework.stereotype.Service

@Service
class DiceService(override val repository: DiceRepository) :
        EntityService<DiceEntity, CustomDice, String> {
    override fun DiceEntity.toDto() = CustomDice(this.id, this.faces)
    override fun CustomDice.toEntity() = DiceEntity(this.id!!, this.faces!!)
}