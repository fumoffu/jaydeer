package fr.jaydeer.dice.custom

import fr.jaydeer.common.repository.BusinessMongoRepository

interface CustomDiceRepository : BusinessMongoRepository<CustomDiceEntity, CustomDiceEntity.Id>