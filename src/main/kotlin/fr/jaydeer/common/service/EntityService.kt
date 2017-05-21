package fr.jaydeer.common.service

import fr.jaydeer.common.domain.Entity
import fr.jaydeer.common.dto.EntityDto
import org.springframework.data.repository.PagingAndSortingRepository
import java.io.Serializable

interface EntityService<T : Entity, U : EntityDto, ID : Serializable> {
    val repository: PagingAndSortingRepository<T, ID>


    fun find(id: ID): U? {
        return repository.findById(id).map { it.toDto() }.orElse(null)
    }

    fun save(entityDto: U): U {
        return repository.save(entityDto.toEntity()).toDto()
    }

    fun delete(id: ID) {
        return repository.deleteById(id)
    }

    fun T.toDto(): U
    fun U.toEntity(): T
}