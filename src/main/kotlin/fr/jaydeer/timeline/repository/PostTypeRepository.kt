package fr.jaydeer.timeline.repository

import fr.jaydeer.timeline.entity.PostType
import org.springframework.data.repository.CrudRepository

interface PostTypeRepository: CrudRepository<PostType, String> {
}
