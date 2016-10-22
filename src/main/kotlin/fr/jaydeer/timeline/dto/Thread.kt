package fr.jaydeer.timeline.dto

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.timeline.entity.ThreadEntity

data class Thread(
        val id: String,
        val name: String): Entitiable<ThreadEntity> {
    override fun toEntity(): ThreadEntity = ThreadEntity(id, name)
}