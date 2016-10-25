package fr.jaydeer.common.dto

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.common.entity.TypeEntity

data class Type(val id: String): Entitiable<TypeEntity> {
    override fun toEntity() = TypeEntity(id)
}