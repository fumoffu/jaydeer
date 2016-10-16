package fr.jaydeer.timeline.validation

import fr.jaydeer.timeline.entity.Post
import fr.jaydeer.timeline.repository.PostTypeRepository
import fr.jaydeer.timeline.repository.ThreadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
open class PostValidator @Autowired constructor(
        val postTypeRepository: PostTypeRepository,
        val threadRepository: ThreadRepository) : Validator {

    override fun validate(target: Any, errors: Errors) {
        val post: Post = target as Post
        when {
            !threadRepository.exists(post.threadId) -> errors.rejectValue("threadId", "thread.unknown")
            !postTypeRepository.exists(post.typeId) -> errors.rejectValue("typeId", "post-type.unknown")
        }
    }

    override fun supports(clazz: Class<*>): Boolean {
        return Post::class.java == clazz
    }
}