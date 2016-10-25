package fr.jaydeer.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.*

@Component
@ConfigurationProperties(prefix="jaydeer.common")
open class TypeProperties {

    var typeCollection: String = ""
        get
        set

    var provisionned: List<NewType> = ArrayList()
        get
        set

    class NewType() {
        lateinit var id: String
        lateinit var category: String
    }
}