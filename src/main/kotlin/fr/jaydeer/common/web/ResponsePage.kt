package fr.jaydeer.common.web

import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponsePage<T>: ResponseEntity<List<T>> {

    constructor(page: Page<T>): super(page.content, headers(page), status(page))

    companion object {
        fun <T> status(page: Page<T>) = if (page.isFirst && page.isLast) HttpStatus.OK else HttpStatus.PARTIAL_CONTENT
        fun <T> headers(page: Page<T>): HttpHeaders {
            val headers = HttpHeaders()
            headers.totalCount = page.totalElements
            return headers
        }
    }
}