package fr.jaydeer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.data.mongodb.config.EnableMongoAuditing

@EnableMongoAuditing
@SpringBootApplication
@EnableConfigurationProperties
open class JaydeerGameApplication

fun main(args: Array<String>) {
    SpringApplication.run(JaydeerGameApplication::class.java, *args)
}
