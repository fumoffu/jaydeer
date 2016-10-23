package fr.jaydeer.dice.repository

import fr.jaydeer.dice.entity.CustomDiceEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface CustomDiceRepository: PagingAndSortingRepository<CustomDiceEntity, String> {
}