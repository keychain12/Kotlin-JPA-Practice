package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.domain.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BoardRepository : JpaRepository<Board, Long> {



}