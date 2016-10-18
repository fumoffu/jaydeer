package fr.jaydeer

import fr.jaydeer.timeline.entity.Post
import fr.jaydeer.timeline.service.PostService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.validation.ConstraintViolationException

@RunWith(SpringRunner::class)
@SpringBootTest
class JaydeerGameApplicationTests {

    @Autowired
    lateinit var postService: PostService

    @Test(expected = ConstraintViolationException::class)
    fun createPost() {
        postService.create(Post("1", "voice-over", "Hello world"))
    }

}
