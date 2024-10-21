package dpi.cst.mahmudulhasan.communityanticorruptionhub.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Discussion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var title: String = "",
    var content: String = "",
    var createdAt: String = LocalDateTime.now().toString(),
   var userId:Int = 0,
)