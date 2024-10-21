package dpi.cst.mahmudulhasan.communityanticorruptionhub.models

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Users

data class LoginResp(
    var user : Users? = null,
    var status: String = ""

)
