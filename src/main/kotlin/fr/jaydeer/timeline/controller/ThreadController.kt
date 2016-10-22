package fr.jaydeer.timeline.controller

import fr.jaydeer.timeline.dto.NewThread
import fr.jaydeer.timeline.dto.Thread
import fr.jaydeer.timeline.service.ThreadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/threads")
open class ThreadController @Autowired constructor(val threadService: ThreadService) {

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun newThread(@RequestBody @Valid newThread: NewThread): Thread {
        return threadService.save(newThread)
    }

}