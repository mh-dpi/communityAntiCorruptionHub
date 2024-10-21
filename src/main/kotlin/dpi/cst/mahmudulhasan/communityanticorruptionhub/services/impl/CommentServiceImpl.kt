package dpi.cst.mahmudulhasan.communityanticorruptionhub.services.impl

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Comment
import dpi.cst.mahmudulhasan.communityanticorruptionhub.repository.CommentRepository
import dpi.cst.mahmudulhasan.communityanticorruptionhub.services.CommentService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class CommentServiceImpl (val repo: CommentRepository): CommentService{
    override fun getAllComments(): List<Comment> = repo.findAll()

    override fun getCommentById(id: Long): Comment? {

        return repo.findById(id).orElse(null)
    }

    override fun saveComment(comment: Comment): Comment
    {
        return repo.save(comment)
    }

    override fun updateComment(comment: Comment): Comment? = repo.save(comment)

    override fun deleteComment(comment: Long) = repo.deleteById(comment)

    override fun findByDiscussionId(id: Int): List<Comment>?{
        return repo.findByDiscussionId(id)
    }

    override fun findAllByUserId(userId: Int): List<Comment>? {
        return repo.findAllByUserId(userId)
    }

}