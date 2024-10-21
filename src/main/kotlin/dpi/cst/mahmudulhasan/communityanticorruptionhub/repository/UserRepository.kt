package dpi.cst.mahmudulhasan.communityanticorruptionhub.repository

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long> {
    fun findByName(name: String): List<Users>
    fun findByEmail(email: String): Users?
    fun findByEmailAndPassword(email: String, password: String):Users?
}