package fr.jaydeer.common.repository

import fr.jaydeer.common.entity.TypeEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface TypeRepository: PagingAndSortingRepository<TypeEntity, String> {
    fun findByIdAndCategory(id: String, category: String): TypeEntity?
}
