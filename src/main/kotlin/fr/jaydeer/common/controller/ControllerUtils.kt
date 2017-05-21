package fr.jaydeer.common.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun <T> T?.toResponse(status: HttpStatus = HttpStatus.OK): ResponseEntity<T> {
    return if(this == null) ResponseEntity(HttpStatus.NOT_FOUND) else ResponseEntity(this, status)
}