package fr.jaydeer.timeline.entity

import fr.jaydeer.common.conversion.Transferable
import fr.jaydeer.timeline.dto.Thread
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = ThreadEntity.collectionId)
class ThreadEntity(): Transferable<Thread> {

    @Id
    var id: String? = null
    lateinit var name: String

    constructor(name: String) : this() {
        this.name = name
    }

    constructor(id: String, name: String) : this(name) {
        this.id = id
    }

    override fun toDTO(): Thread = Thread(id!!, name)

    companion object {
        const val collectionId = "threads"
    }
}