package fr.jaydeer.actor.dto

import fr.jaydeer.actor.entity.ActorEntity
import fr.jaydeer.common.conversion.Entitiable

data class Actor(val id: String,
                 val name: String,
                 val typeId: String,
                 val pictureId: String?): Entitiable<ActorEntity> {
    override fun toEntity(): ActorEntity = ActorEntity()
}