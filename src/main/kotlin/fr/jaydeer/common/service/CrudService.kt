package fr.jaydeer.common.service

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.common.conversion.Transferable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository
import java.io.Serializable

open class CrudService<T, U: Transferable<T>, in ID: Serializable>(
        private val repository: PagingAndSortingRepository<U, ID>) {

    fun findOne(id: ID): T = repository.findOne(id).toDTO()
    fun exists(id: ID): Boolean = repository.exists(id)
    fun findAll(): Iterable<T> = repository.findAll().map { it.toDTO() }
    fun findAll(ids: Iterable<ID>): Iterable<T> = repository.findAll(ids).map { it.toDTO() }
    fun count(): Long = repository.count()
    fun delete(id: ID) = repository.delete(id)
    fun deleteAll() = repository.deleteAll()
    fun findAll(sort: Sort): Iterable<T> = repository.findAll(sort).map { it.toDTO() }
    fun findAll(pageable: Pageable): Page<T> = repository.findAll(pageable).map { it.toDTO() }

    fun <S : Entitiable<U>> save(entity: S): T = repository.save(entity.toEntity()).toDTO()
    fun <S : Entitiable<U>> save(entities: Iterable<S>): Iterable<T>
            = repository.save(entities.map{ it.toEntity() }).map { it.toDTO() }
}