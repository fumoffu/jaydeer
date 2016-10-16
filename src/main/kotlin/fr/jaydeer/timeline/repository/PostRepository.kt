package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository: CrudRepository<Post, String> {
}