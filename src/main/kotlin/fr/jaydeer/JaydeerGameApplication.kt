package fr.jaydeer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class JaydeerGameApplication

fun main(args: Array<String>) {
    SpringApplication.run(JaydeerGameApplication::class.java, *args)
}
