package dpi.cst.mahmudulhasan.communityanticorruptionhub.models

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Discussion
import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Users

data class DiscussionResp (
    var data : Discussion? = Discussion(),
    var status: String = ""
)
