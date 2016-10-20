package fr.jaydeer.timeline.request

import fr.jaydeer.common.conversion.Entitiable
import fr.jaydeer.timeline.entity.Thread
import javax.validation.constraints.NotNull

data class NewThreadRequest(
        @NotNull
        val name: String): Entitiable<Thread> {

    override fun toEntity() = Thread(name)

}