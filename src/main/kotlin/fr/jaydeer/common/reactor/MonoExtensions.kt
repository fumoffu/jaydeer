package fr.jaydeer.common.reactor

import reactor.core.Disposable
import reactor.core.publisher.Mono

fun <T> Mono<T>.applySubscribe(block: T.() -> Unit): Disposable {
    return this.subscribe(block)
}