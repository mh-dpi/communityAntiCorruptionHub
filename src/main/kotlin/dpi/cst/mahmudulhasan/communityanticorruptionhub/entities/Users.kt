package dpi.cst.mahmudulhasan.communityanticorruptionhub.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var role: String = "",
    var status: String = "",
    var createdAt: String = "",
    var updatedAt: String? = "",
    var deletedAt: String? = ""
)