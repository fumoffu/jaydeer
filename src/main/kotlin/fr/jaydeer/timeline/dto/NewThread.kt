package fr.jaydeer.timeline.dto

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.timeline.entity.ThreadEntity
import javax.validation.constraints.NotNull

data class NewThread(
        @NotNull
        val name: String): Entitiable<ThreadEntity> {

    override fun toEntity() = ThreadEntity(name)

}