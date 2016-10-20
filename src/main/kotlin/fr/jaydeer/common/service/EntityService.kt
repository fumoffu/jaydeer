package fr.jaydeer.common.service

import fr.jaydeer.common.conversion.Entitiable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository
import java.io.Serializable

open class EntityService<T, in ID: Serializable>(private val repository: PagingAndSortingRepository<T, ID>) {
    fun <S : T> save(entity: S): S = repository.save(entity)
    fun <S : T> save(entities: Iterable<S>): Iterable<S> = repository.save(entities)
    fun findOne(id: ID): T = repository.findOne(id)
    fun exists(id: ID): Boolean = repository.exists(id)
    fun findAll(): Iterable<T> = repository.findAll()
    fun findAll(ids: Iterable<ID>): Iterable<T> = repository.findAll(ids)
    fun count(): Long = repository.count()
    fun delete(id: ID) = repository.delete(id)
    fun delete(entity: T) = repository.delete(entity)
    fun delete(entities: Iterable<T>) = repository.delete(entities)
    fun deleteAll() = repository.deleteAll()
    fun findAll(sort: Sort): Iterable<T> = repository.findAll(sort)
    fun findAll(pageable: Pageable): Page<T> = repository.findAll(pageable)

    fun <S : Entitiable<U>, U : T> saveFrom(entity: S): U = repository.save(entity.toEntity())
    fun <S : Entitiable<U>, U : T> saveFrom(entities: Iterable<S>): Iterable<U>
            = repository.save(entities.map{ it.toEntity() })
}