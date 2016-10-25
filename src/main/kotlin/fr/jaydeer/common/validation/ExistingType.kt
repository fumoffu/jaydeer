package fr.jaydeer.common.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(ExistingTypeValidator::class))
annotation class ExistingType(val category: String,
                            val message: String = "{fr.jaydeer.common.validation.ExistingType.message}",
                            val groups: Array<KClass<*>> = arrayOf(),
                            val payload: Array<KClass<out Payload>> = arrayOf())

