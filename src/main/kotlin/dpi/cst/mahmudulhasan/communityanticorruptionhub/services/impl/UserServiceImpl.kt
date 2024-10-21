package dpi.cst.mahmudulhasan.communityanticorruptionhub.services.impl

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Users
import dpi.cst.mahmudulhasan.communityanticorruptionhub.models.LoginReq
import dpi.cst.mahmudulhasan.communityanticorruptionhub.repository.UserRepository
import dpi.cst.mahmudulhasan.communityanticorruptionhub.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class UserServiceImpl : UserService {
    @Autowired
    lateinit var repo: UserRepository
    override fun getAllUsers(): List<Users> {
        return repo.findAll()
    }

    override fun getUserById(id: Long): Users? {
        return repo.findById(id).orElse(null)
    }

    override fun saveUser(user: Users): Users {
        return repo.save(user)
    }

    override fun updateUser(user: Users): Users {
        return repo.save(user)
    }

    override fun deleteUser(id: Long) {
        return repo.deleteById(id)
    }

    override fun getUserByName(name: String): List<Users> {
        return repo.findByName(name)
    }

    override fun getUserByEmail(email: String): Users? {
        return repo.findByEmail(email)
    }

    override fun getUserByEmailAndPassword(loginReq: LoginReq): Users? {
        return repo.findByEmailAndPassword(loginReq.email,loginReq.password)
    }


}