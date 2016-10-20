package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.Thread
import org.springframework.data.repository.PagingAndSortingRepository

interface ThreadRepository: PagingAndSortingRepository<Thread, String> {
}
