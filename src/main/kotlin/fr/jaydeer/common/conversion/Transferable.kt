package fr.jaydeer.common.conversion

interface Transferable<T> {
    fun toDTO(): T
}