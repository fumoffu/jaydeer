package fr.jaydeer.common.api.validation

import javax.validation.Payload
import kotlin.annotation.AnnotationTarget.*
import kotlin.annotation.AnnotationRetention.*
import kotlin.reflect.KClass

@Target(PROPERTY_GETTER, VALUE_PARAMETER)
@Retention(RUNTIME)
@javax.validation.Constraint(validatedBy = arrayOf(ExistingIdValidator::class))
annotation class ExistingId(val value: KClass<out Any>,
                            val message: String = "{fr.jaydeer.common.api.validation.ExistingId.message}",
                            val groups: Array<KClass<*>> = arrayOf(),
                            val payload: Array<KClass<out Payload>> = arrayOf())

