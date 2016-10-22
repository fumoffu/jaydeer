package fr.jaydeer.timeline.service

import fr.jaydeer.common.service.CrudService
import fr.jaydeer.timeline.dto.Thread
import fr.jaydeer.timeline.entity.ThreadEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Service

@Service
class ThreadService(repository: PagingAndSortingRepository<ThreadEntity, String>):
        CrudService<Thread, ThreadEntity, String>(repository) {
}