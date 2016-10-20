package fr.jaydeer.common.conversion

interface Entitiable<T> {
    fun toEntity(): T
}