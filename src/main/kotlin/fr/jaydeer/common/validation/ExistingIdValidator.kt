package fr.jaydeer.common.validation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.data.repository.CrudRepository
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ExistingIdValidator: ConstraintValidator<ExistingId, String>  {

    @Autowired
    lateinit var context: ApplicationContext

    private lateinit var repository: CrudRepository<out Any, String>

    override fun isValid(value: String, context: ConstraintValidatorContext): Boolean {
        return repository.exists(value)
    }

    override fun initialize(constraintAnnotation: ExistingId) {
        this.repository = context.getBean(constraintAnnotation.crudRepository.java)
    }
}