package dpi.cst.mahmudulhasan.communityanticorruptionhub.services

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Comment

interface CommentService {

    fun getAllComments (): List<Comment>
    fun getCommentById(id: Long): Comment?
    fun saveComment(comment : Comment) : Comment
    fun updateComment(comment : Comment) : Comment?
    fun deleteComment(comment : Long)
    fun findByDiscussionId(id: Int): List<Comment>?
    fun findAllByUserId(userId: Int): List<Comment>?
}