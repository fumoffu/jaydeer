package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.PostType
import org.springframework.data.repository.PagingAndSortingRepository

interface PostTypeRepository: PagingAndSortingRepository<PostType, String> {
}
