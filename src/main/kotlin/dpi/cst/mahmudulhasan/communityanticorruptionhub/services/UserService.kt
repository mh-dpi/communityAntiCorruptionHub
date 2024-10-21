package dpi.cst.mahmudulhasan.communityanticorruptionhub.services

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Users
import dpi.cst.mahmudulhasan.communityanticorruptionhub.models.LoginReq

interface UserService {
    fun getAllUsers(): List<Users>
    fun getUserById(id: Long): Users?
    fun saveUser(user: Users): Users
    fun updateUser(user: Users): Users
    fun deleteUser(id: Long)
    fun getUserByName(name: String): List<Users>
    fun getUserByEmail(email: String): Users?
    fun getUserByEmailAndPassword(loginReq: LoginReq): Users?
}