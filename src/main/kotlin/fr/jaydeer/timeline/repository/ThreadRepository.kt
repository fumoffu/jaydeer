package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.Thread
import org.springframework.data.repository.CrudRepository

interface ThreadRepository: CrudRepository<Thread, String> {
}
