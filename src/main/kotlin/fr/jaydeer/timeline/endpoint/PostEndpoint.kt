package fr.jaydeer.timeline.endpoint

import fr.jaydeer.timeline.entity.Post
import fr.jaydeer.timeline.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Component
@Path("/posts")
@Produces("application/json")
open class PostEndpoint @Autowired constructor(val postService: PostService) {

    @POST
    fun createPost(newPost: Post): Post {
        return postService.create(newPost)
    }

}