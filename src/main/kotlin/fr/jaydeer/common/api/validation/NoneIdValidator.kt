package fr.jaydeer.common.api.validation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.support.Repositories
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class NoneIdValidator : ConstraintValidator<NoneId, String?> {

    @Autowired
    lateinit var context: ApplicationContext

    lateinit var repository: CrudRepository<Any, String?>

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        return value == null || !repository.existsById(value)
    }

    override fun initialize(constraintAnnotation: NoneId) {
        val repositories = Repositories(context)
        this.repository = repositories.getRepositoryFor(constraintAnnotation.value.java).get()
                as CrudRepository<Any, String?>
    }
}