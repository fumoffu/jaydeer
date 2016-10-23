package fr.jaydeer.dice.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer

@JsonSerialize(using = ToStringSerializer::class)
data class StringFace(val value: String): Face {
    override fun toString(): String {
        return value
    }
}

fun String.toFace() = StringFace(this)