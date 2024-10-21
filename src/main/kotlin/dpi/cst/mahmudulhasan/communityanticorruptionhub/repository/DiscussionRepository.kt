package dpi.cst.mahmudulhasan.communityanticorruptionhub.repository

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Discussion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface DiscussionRepository : JpaRepository<Discussion,Long> {
    fun findByTitleContainingOrContentContaining(title: String?,content: String?): List<Discussion?>?
}