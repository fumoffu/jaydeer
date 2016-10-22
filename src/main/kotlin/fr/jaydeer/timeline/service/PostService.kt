package fr.jaydeer.timeline.service

import fr.jaydeer.common.service.CrudService
import fr.jaydeer.timeline.dto.Post
import fr.jaydeer.timeline.entity.PostEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Service

@Service
class PostService(repository: PagingAndSortingRepository<PostEntity, String>):
        CrudService<Post, PostEntity, String>(repository) {
}