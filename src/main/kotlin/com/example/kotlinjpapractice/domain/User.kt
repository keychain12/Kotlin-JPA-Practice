package com.example.kotlinjpapractice.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "TestUser")
class User(

        var name: String,
        var password:String,
        @OneToMany(mappedBy = "user")
        val board: List<Board> = listOf()) {
        @Id
        @GeneratedValue
        val id: Long = 0

}


