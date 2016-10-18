package fr.jaydeer.common.validation

import org.springframework.data.repository.CrudRepository
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(ExistingIdValidator::class))
annotation class ExistingId(val value: KClass<out CrudRepository<out Any, String>>,
                            val message: String = "{fr.jaydeer.common.validation.ExistingId.message}",
                            val groups: Array<KClass<*>> = arrayOf(),
                            val payload: Array<KClass<out Payload>> = arrayOf())

