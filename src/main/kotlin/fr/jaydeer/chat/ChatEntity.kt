package fr.jaydeer.chat
import fr.jaydeer.chat.instance.InstanceProvider
import fr.jaydeer.common.domain.Entity

interface ChatEntity : Entity {
    override val id: Id
    interface Id {
        val entity: Any
        val provider: InstanceProvider
    }
}