package fr.jaydeer.timeline.service

import fr.jaydeer.common.service.EntityService
import fr.jaydeer.timeline.entity.Thread
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Service

@Service
class ThreadService(repository: PagingAndSortingRepository<Thread, String>): EntityService<Thread, String>(repository) {
}