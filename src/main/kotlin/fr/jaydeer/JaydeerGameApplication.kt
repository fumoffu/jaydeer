package fr.jaydeer

import fr.jaydeer.chat.message.TextMessage
import fr.jaydeer.chat.instance.ChatInstance
import fr.jaydeer.chat.ChatService
import fr.jaydeer.common.reactor.applySubscribe
import org.bson.types.ObjectId
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.data.mongodb.config.EnableMongoAuditing
import javax.annotation.PostConstruct

@EnableMongoAuditing
@SpringBootApplication
@EnableConfigurationProperties
class JaydeerGameApplication(val chatService: ChatService) {


    @PostConstruct
    fun doSomething() {
        chatService.chat(ObjectId()).applySubscribe {
            sendMessage(TextMessage("Hello :)"))
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(JaydeerGameApplication::class.java, *args)
}
