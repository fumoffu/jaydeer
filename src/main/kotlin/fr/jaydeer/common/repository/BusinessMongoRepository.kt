package fr.jaydeer.common.repository

import fr.jaydeer.common.domain.Entity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface BusinessMongoRepository<T, in ID: Entity.Id>: MongoRepository<T, ObjectId> {
    fun findById(id: ID): Optional<T>
    fun existsById(id: ID): Boolean
}