package fr.jaydeer.common.validation

import fr.jaydeer.common.repository.TypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ExistingTypeValidator: ConstraintValidator<ExistingType, String>  {

    @Autowired
    lateinit var context: ApplicationContext

    @Autowired
    lateinit var repository: TypeRepository

    private lateinit var category: String

    override fun isValid(value: String, context: ConstraintValidatorContext): Boolean {
        return repository.findByIdAndCategory(value, category) != null
    }

    override fun initialize(constraintAnnotation: ExistingType) {
        this.category = constraintAnnotation.category
    }
}