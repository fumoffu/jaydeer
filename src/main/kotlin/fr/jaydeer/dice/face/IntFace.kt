package fr.jaydeer.dice.face

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import fr.jaydeer.dice.face.Face

@JsonSerialize(using = ToStringSerializer::class)
data class IntFace(val number: Int): Face {
    override fun toString(): String {
        return number.toString()
    }
}