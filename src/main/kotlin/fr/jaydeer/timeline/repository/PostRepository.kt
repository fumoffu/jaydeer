package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.PostEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface PostRepository: PagingAndSortingRepository<PostEntity, String> {
}