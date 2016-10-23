package fr.jaydeer.dice.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer

@JsonSerialize(using = ToStringSerializer::class)
data class IntFace(val number: Int): Face {
    override fun toString(): String {
        return number.toString()
    }
}