package fr.jaydeer.timeline.service

import fr.jaydeer.timeline.entity.Post
import fr.jaydeer.timeline.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Service
@Validated
open class PostService @Autowired constructor(
        private val postRepository: PostRepository) {

    open fun create(@Valid post: Post): Post {
        return postRepository.save(post)
    }
}