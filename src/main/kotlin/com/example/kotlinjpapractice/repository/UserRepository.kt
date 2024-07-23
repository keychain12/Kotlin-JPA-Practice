package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): Optional<User>


}