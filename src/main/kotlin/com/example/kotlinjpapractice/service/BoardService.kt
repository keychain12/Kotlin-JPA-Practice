package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.domain.Board
import com.example.kotlinjpapractice.domain.User
import com.example.kotlinjpapractice.repository.BoardRepository
import com.example.kotlinjpapractice.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import java.util.*

@Service
@Transactional
class BoardService(private val boardRepository: BoardRepository, private val userRepository: UserRepository) {

    @Transactional(readOnly = true)
    fun getAllBoard(): List<Board> = boardRepository.findAll()
    @Transactional(readOnly = true)
    fun getBoardById(id: Long): Board = boardRepository.findById(id).orElse(null)

    fun save(board: Board)  {

        boardRepository.save(board)

    }
    fun update(title: String, content: String, user: User, id: Long) {
        var board = boardRepository.findById(id).orElseThrow{ IllegalArgumentException("보드x")}


        board.update(title = title, content = content, user = user)

    }
    fun delete(board: Board) {
        boardRepository.delete(board)
    }



}