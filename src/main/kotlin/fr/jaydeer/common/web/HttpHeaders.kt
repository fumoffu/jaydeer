package fr.jaydeer.common.web

import org.springframework.http.HttpHeaders

class HttpHeaders : HttpHeaders() {
    val X_TOTAL_COUNT = "X_TOTAL_COUNT"

    var totalCount: Long
        get() = getFirst(X_TOTAL_COUNT).toLong()
        set(totalCount: Long) = set(X_TOTAL_COUNT, totalCount.toString())
}

