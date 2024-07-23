package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.domain.User
import com.example.kotlinjpapractice.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class LoginService(private val userRepository: UserRepository){


    fun login(name: String, password: String): User? {
        val user = userRepository.findByName(name).orElse(null) // 있으면 user 없으면 null 반환
        return user?.takeIf { it.password == password } // takeIf 해당조건식이 참인경우 user 반환 아니면 null 반환


    }

}