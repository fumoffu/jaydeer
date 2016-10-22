package fr.jaydeer.timeline.controller

import fr.jaydeer.common.web.ResponsePage
import fr.jaydeer.timeline.dto.NewPost
import fr.jaydeer.timeline.dto.Post
import fr.jaydeer.timeline.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
open class PostController @Autowired constructor(val postService: PostService) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun listPost(pageable: Pageable): ResponsePage<Post> {
        return ResponsePage(postService.findAll(pageable))
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun newPost(@RequestBody @Valid newPost: NewPost): Post {
        return postService.save(newPost)
    }

}