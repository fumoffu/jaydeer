package fr.jaydeer.common.domain

import org.bson.types.ObjectId

interface Stored {
    val storageId: ObjectId?
}