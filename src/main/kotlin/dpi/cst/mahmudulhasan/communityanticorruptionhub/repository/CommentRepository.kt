package dpi.cst.mahmudulhasan.communityanticorruptionhub.repository

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository:JpaRepository<Comment,Long> {
    fun findByDiscussionId(discussionId: Int): List<Comment>?
    fun findAllByUserId(userId: Int): List<Comment>?
}