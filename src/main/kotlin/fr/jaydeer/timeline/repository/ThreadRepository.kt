package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.ThreadEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface ThreadRepository: PagingAndSortingRepository<ThreadEntity, String> {
}
