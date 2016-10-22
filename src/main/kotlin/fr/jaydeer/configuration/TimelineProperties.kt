package fr.jaydeer.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.*

@Component
@ConfigurationProperties(prefix="jaydeer.timeline")
open class TimelineProperties {

    var postTypes: List<String> = ArrayList()
        get
        set

}