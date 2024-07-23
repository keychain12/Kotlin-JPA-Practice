package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.domain.Member
import com.example.kotlinjpapractice.domain.User
import com.example.kotlinjpapractice.service.LoginService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController(private val loginService: LoginService){

    @GetMapping("/login")
    fun loginForm(): String {

        return "login"
    }

    @PostMapping("/login")
    fun login(user: User,model: Model,request: HttpServletRequest): String {
        val loggedInUser = loginService.login(user.name, user.password)

        return if (loggedInUser != null) {
            val session = request.getSession(true)
            session.setAttribute(Member.SILVER.name, loggedInUser)
            println("session = ${session.getAttribute(Member.SILVER.name)}")
            return "redirect:/"
        } else {
            return "redirect:/login"
        }


    }

}