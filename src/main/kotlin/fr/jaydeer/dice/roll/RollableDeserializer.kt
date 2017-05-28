package fr.jaydeer.dice.roll

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer


class RollableDeserializer(type: Class<Rollable>?) : StdDeserializer<Rollable>(type) {

    constructor(): this(null)

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Rollable {
        while (p.nextToken() != JsonToken.END_OBJECT) {
            val field = p.currentName
            if(field == "id") {
                return ctxt.readValue(p, IdRoll::class.java)
            } else if(field == "faces") {
                return ctxt.readValue(p, CustomDiceRoll::class.java)
            } else if(field == "n") {
                return ctxt.readValue(p, IntDiceRoll::class.java)
            }
        }
        throw IllegalArgumentException("Cannot deserialize into Rollable")
    }
}