package dpi.cst.mahmudulhasan.communityanticorruptionhub.services.impl

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Discussion
import dpi.cst.mahmudulhasan.communityanticorruptionhub.repository.DiscussionRepository
import dpi.cst.mahmudulhasan.communityanticorruptionhub.services.DiscussionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DiscussionServiceImpl: DiscussionService {

    @Autowired
    lateinit var repo: DiscussionRepository

    override fun getAllDiscussion(): List<Discussion> = repo.findAll()

    override fun getDiscussionById(id: Long): Discussion? =repo.findByIdOrNull(id)

    override fun saveDiscussion(discussion: Discussion): Discussion = repo.save(discussion)

    override fun updateDiscussion(discussion: Discussion): Discussion {

        if (repo.existsById(discussion.id)){
            return repo.save(discussion)
        }

        return discussion
    }

    override fun deleteDiscussion(id: Long): Boolean {

        if (repo.existsById(id)){
            repo.deleteById(id)
            return true
        }

        return false
    }

    override fun searchDiscussionsByKeyword(keyword: String?): List<Discussion?>? = repo.findByTitleContainingOrContentContaining(keyword,keyword)
}