package fr.jaydeer.configuration

import fr.jaydeer.common.repository.TypeRepository
import fr.jaydeer.common.service.TypeService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

enum class TypeCategory(val id: String) {
    POST(TypeCategory.POST),
    ACTOR(TypeCategory.ACTOR);

    override fun toString() = id

    companion object {
        const val POST = "POST"
        const val ACTOR = "ACTOR"
    }
}

@Configuration
open class TypeConfiguration {

    @Bean
    open fun typeService(repository: TypeRepository,
                         typeProperties: TypeProperties)
        = TypeService(TypeCategory::class, repository, typeProperties)
}