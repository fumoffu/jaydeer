package fr.jaydeer.timeline.dto

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.timeline.entity.PostTypeEntity

data class PostType(val id: String): Entitiable<PostTypeEntity> {
    override fun toEntity(): PostTypeEntity = PostTypeEntity(id)
}