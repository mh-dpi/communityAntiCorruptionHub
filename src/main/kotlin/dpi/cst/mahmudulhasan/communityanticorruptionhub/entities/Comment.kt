package dpi.cst.mahmudulhasan.communityanticorruptionhub.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var content: String = "",
    var createdAt: String = LocalDateTime.now().toString(),
    val discussionId: Int? = null,
    val userId: Int = 0
)