package fr.jaydeer.dice.face

@com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.databind.ser.std.ToStringSerializer::class)
data class StringFace(val value: String): Face {
    override fun toString(): String {
        return value
    }
}

fun String.toFace() = fr.jaydeer.dice.face.StringFace(this)