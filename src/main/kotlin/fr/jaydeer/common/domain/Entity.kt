package fr.jaydeer.common.domain

import org.bson.types.ObjectId

interface Entity {
    val storageId: ObjectId?
    val id: Any
}