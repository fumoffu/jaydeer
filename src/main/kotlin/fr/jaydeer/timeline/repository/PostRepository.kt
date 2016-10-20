package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.Post
import org.springframework.data.repository.PagingAndSortingRepository

interface PostRepository: PagingAndSortingRepository<Post, String> {
}