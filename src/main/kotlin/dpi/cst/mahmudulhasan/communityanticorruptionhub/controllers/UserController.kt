package dpi.cst.mahmudulhasan.communityanticorruptionhub.controllers

import dpi.cst.mahmudulhasan.communityanticorruptionhub.entities.Users
import dpi.cst.mahmudulhasan.communityanticorruptionhub.models.LoginReq
import dpi.cst.mahmudulhasan.communityanticorruptionhub.models.LoginResp
import dpi.cst.mahmudulhasan.communityanticorruptionhub.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("home/user")
class UserController {
    @Autowired
    lateinit var userService: UserService


    @GetMapping()
    fun getAllUsers() = userService.getAllUsers()

    @PostMapping()
    fun saveUser(@RequestBody user: Users) :ResponseEntity<Users?> {
        if (user.name.isNotEmpty() && user.password.isNotEmpty()  && user.email.isNotEmpty() && user.role.isNotEmpty() && user.status.isNotEmpty() && user.createdAt.isNotEmpty() ) {
            return ResponseEntity.ok(userService.saveUser(user))
        }
        return ResponseEntity.badRequest().build()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long) = userService.getUserById(id)

    @GetMapping("/{name}")
    fun getUserByName(@PathVariable name: String) = userService.getUserByName(name)

    @GetMapping("/{email}")
    fun getUserByEmail(@PathVariable email: String) = userService.getUserByEmail(email)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: Users) = userService.updateUser(user)

    @PostMapping("/login")
    fun login(@RequestBody loginReq: LoginReq):ResponseEntity<Users> {
        val user = userService.getUserByEmailAndPassword(loginReq)
        if (user != null) {
            return ResponseEntity.ok(user)
        }
        return ResponseEntity.notFound().build()

    }



}