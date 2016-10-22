package fr.jaydeer.timeline.service

import fr.jaydeer.common.service.CrudService
import fr.jaydeer.configuration.TimelineProperties
import fr.jaydeer.timeline.dto.PostType
import fr.jaydeer.timeline.entity.PostTypeEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class PostTypeService(
        repository: PagingAndSortingRepository<PostTypeEntity, String>,
        val timelineProperties: TimelineProperties) :
        CrudService<PostType, PostTypeEntity, String>(repository) {

    @PostConstruct
    fun initPostType() {
        save(timelineProperties.postTypes.map(::PostType))
    }
}