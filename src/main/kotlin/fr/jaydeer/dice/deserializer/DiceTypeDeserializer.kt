package fr.jaydeer.dice.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import fr.jaydeer.dice.dto.DiceType
import java.io.IOException

class DiceTypeDeserializer @JvmOverloads constructor(vc: Class<*>? = null) : StdDeserializer<DiceType>(vc) {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): DiceType {
        val type = jp.codec.readValue(jp, String::class.java)
        return DiceType.forValue(type)
    }
}