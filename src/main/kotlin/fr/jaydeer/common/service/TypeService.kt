package fr.jaydeer.common.service

import fr.jaydeer.common.entity.TypeEntity
import fr.jaydeer.common.repository.TypeRepository
import fr.jaydeer.configuration.TypeProperties
import javax.annotation.PostConstruct
import kotlin.reflect.KClass

class TypeService<T: Enum<T>>(
        val categoryClass: KClass<T>,
        val repository: TypeRepository,
        val typeProperties: TypeProperties) {

    @PostConstruct
    fun init() {
        typeProperties.provisionned.forEach {
            val category = java.lang.Enum.valueOf(categoryClass.java, it.category)
            if(repository.findByIdAndCategory(it.id, it.category) == null) {
                save(it.id, category)
            }
        }
    }

    fun save(id: String, category: T) {
        repository.save(TypeEntity(id, category.toString()))
    }
}