package fr.jaydeer.chat.instance

import fr.jaydeer.common.domain.Entity

interface ChatEntity<out ID: ChatEntity.Id<Any>> : Entity<ID> {
    interface Id<out ID>: Entity.Id {
        val entity: ID
        val provider: InstanceProvider
    }
}