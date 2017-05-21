package fr.jaydeer.common.api.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationTarget.*
import kotlin.annotation.AnnotationRetention.*
import kotlin.reflect.KClass

@Target(PROPERTY_GETTER, VALUE_PARAMETER)
@Retention(RUNTIME)
@Constraint(validatedBy = arrayOf(NoneIdValidator::class))
annotation class NoneId(val value: KClass<out Any>,
                        val message: String = "{fr.jaydeer.common.api.validation.NoneId.message}",
                        val groups: Array<KClass<*>> = arrayOf(),
                        val payload: Array<KClass<out Payload>> = arrayOf())

