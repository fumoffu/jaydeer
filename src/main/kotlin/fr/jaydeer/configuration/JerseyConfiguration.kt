package fr.jaydeer.configuration

import fr.jaydeer.timeline.endpoint.PostEndpoint
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
open class JerseyConfiguration : ResourceConfig() {
    init {
        register(PostEndpoint::class.java)
    }
}