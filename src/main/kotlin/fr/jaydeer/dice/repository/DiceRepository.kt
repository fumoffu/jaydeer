package fr.jaydeer.dice.repository

import fr.jaydeer.dice.entity.DiceEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface DiceRepository : PagingAndSortingRepository<DiceEntity, String>