package fr.jaydeer.timeline.service

import fr.jaydeer.common.service.EntityService
import fr.jaydeer.timeline.entity.PostType
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Service

@Service
class PostTypeService(repository: PagingAndSortingRepository<PostType, String>): EntityService<PostType, String>(repository) {
}