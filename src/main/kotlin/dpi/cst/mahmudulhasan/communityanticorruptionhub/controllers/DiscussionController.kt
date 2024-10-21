package dpi.cst.mahmudulhasan.communityanticorruptionhub.controllers

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Discussion
import dpi.cst.mahmudulhasan.communityanticorruptionhub.models.DiscussionResp
import dpi.cst.mahmudulhasan.communityanticorruptionhub.services.DiscussionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("home/discussion")
class DiscussionController{
    @Autowired
    lateinit var service: DiscussionService

    @GetMapping()
    fun getAllDiscussions(): ResponseEntity<List<Discussion>>  = ResponseEntity.ok(service.getAllDiscussion().map {
        it
    })

    @GetMapping("/{id}")
    fun getDiscussionById(@PathVariable id: Long): ResponseEntity<Discussion?> = ResponseEntity.ok(service.getDiscussionById(id))


    @GetMapping("/keyword/{keyword}")
    fun searchDiscussionsByKeyword(@PathVariable keyword: String): ResponseEntity<List<DiscussionResp>> = ResponseEntity.ok(service.searchDiscussionsByKeyword(keyword)?.map {
        DiscussionResp(it)
    })

    @GetMapping("/user/{userId}")
    fun getDiscussionsByUserId(@PathVariable userId: Long): ResponseEntity<List<DiscussionResp>> = ResponseEntity.ok(service.getAllDiscussion().filter { it.userId == userId.toInt()}.map {
        DiscussionResp(it, HttpStatus.OK.toString())
    })

    @PostMapping
    fun saveDiscussion(@RequestBody discussion: Discussion): ResponseEntity<Discussion?> = ResponseEntity.ok(service.saveDiscussion(discussion))

    @PutMapping("/{id}")
    fun updateDiscussion(@PathVariable id: Long, @RequestBody updatedDiscussion: Discussion): ResponseEntity<Discussion?> = ResponseEntity.ok(service.updateDiscussion(updatedDiscussion))


    @DeleteMapping("/{id}")
    fun deleteDiscussion(@PathVariable id: Long): ResponseEntity<Boolean> = ResponseEntity.ok(service.deleteDiscussion(id)) ?: ResponseEntity.ok(false)


}
