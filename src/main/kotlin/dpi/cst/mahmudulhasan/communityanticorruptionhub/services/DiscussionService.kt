package dpi.cst.mahmudulhasan.communityanticorruptionhub.services

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Discussion

interface DiscussionService {
    fun getAllDiscussion() : List<Discussion>
    fun getDiscussionById(id: Long) : Discussion?
    fun saveDiscussion(discussion: Discussion) : Discussion
    fun updateDiscussion(discussion: Discussion) : Discussion
    fun deleteDiscussion(id: Long) : Boolean
    fun searchDiscussionsByKeyword(keyword: String?) : List<Discussion?>?
}