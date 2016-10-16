package fr.jaydeer.common.validation

import org.springframework.data.repository.CrudRepository
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(ExistingIdValidator::class))
annotation class ExistingId(val crudRepository: KClass<out CrudRepository<out Any, String>>,
                            val message: String = "{message}",
                            val groups: Array<KClass<*>> = arrayOf(),
                            val payload: Array<KClass<out Payload>> = arrayOf())

