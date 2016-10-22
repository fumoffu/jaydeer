package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.PostTypeEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface PostTypeRepository: PagingAndSortingRepository<PostTypeEntity, String> {
}
