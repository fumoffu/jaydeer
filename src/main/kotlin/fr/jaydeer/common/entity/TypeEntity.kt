package fr.jaydeer.common.entity

import fr.jaydeer.common.conversion.Transferable
import fr.jaydeer.common.dto.Type
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "#{typeProperties.typeCollection}")
@CompoundIndexes(
    CompoundIndex(name = "type", def = "{'id': 1, 'category': 1}", unique = true)
)
open class TypeEntity() : Transferable<Type> {

    @Id
    var _id: String? = null
    lateinit var id: String
    var category: String? = null

    constructor(id: String, category: String): this(id) {
        this.category = category
    }

    constructor(id: String): this() {
        this.id = id
    }

    override fun toDTO(): Type = Type(id)
}