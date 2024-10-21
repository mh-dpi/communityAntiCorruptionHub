package dpi.cst.mahmudulhasan.communityanticorruptionhub.controllers

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Comment
import dpi.cst.mahmudulhasan.communityanticorruptionhub.services.CommentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class CommentController (
    val service : CommentService
) {


    @GetMapping("api/comments")
    fun getAllComments(): List<Comment> = service.getAllComments()

    @GetMapping("api/discussion/{id}/comments")
    fun getCommentById(@PathVariable("id") id: Int) = service.findByDiscussionId(id)

    @GetMapping("api/users/{id}/comments")
    fun getAllCommentsByUserId(@PathVariable("id") id: Int) = service.findAllByUserId(id)

    @PostMapping("api/discussion/comments")
    fun saveComments(@RequestBody comments: Comment)  = service.saveComment(comments)

    @DeleteMapping("api/discussion/comments/{id}")
    fun deleteComment(@PathVariable("id") id: Long) = service.deleteComment(id)


}