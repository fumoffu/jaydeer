package fr.jaydeer.common.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface BusinessMongoRepository<T, in ID: Any>: MongoRepository<T, ObjectId> {
    fun findEntityById(id: ID): Optional<T>
    fun existsEntityById(id: ID): Boolean
}