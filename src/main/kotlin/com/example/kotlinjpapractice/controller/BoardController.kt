package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.domain.Board
import com.example.kotlinjpapractice.domain.Member
import com.example.kotlinjpapractice.domain.User
import com.example.kotlinjpapractice.repository.BoardRepository
import com.example.kotlinjpapractice.service.BoardService
import jakarta.persistence.Entity
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpSession
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.net.http.HttpRequest

@Controller
@RequiredArgsConstructor
class BoardController(private val boardService: BoardService) {


    @GetMapping("/")
    fun list(model: Model, request: HttpServletRequest): String {

        val session: HttpSession = request.session

        val boardList: List<Board> = boardService.getAllBoard()



        model.addAttribute("board", boardList)
        return "index"
    }

    @GetMapping("/view/{id}")
    fun view(@PathVariable id: Long, model: Model): String {
        val board = boardService.getBoardById(id)

        model.addAttribute("board", board)
        return "view"
    }

    @GetMapping("/create")
    fun createForm(): String {
        return "create"
    }

    @PostMapping("/create")
    fun create(board: Board, request: HttpServletRequest): String {
        val session: HttpSession = request.session
        val user: User = session.getAttribute(Member.SILVER.name) as User

        board.user = user

        boardService.save(board)

        return "redirect:/"
    }

    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable id: Long, model: Model): String {

        val board: Board = boardService.getBoardById(id)

        model.addAttribute("board", board)
        return "edit"
    }


    @PostMapping("/edit")
    fun edit(
        title: String,
        content: String,
        id: Long,
        redirectAttributes: RedirectAttributes,
        request: HttpServletRequest
    ): String {

        val session: HttpSession = request.session
        val loginUser: User = session.getAttribute(Member.SILVER.name) as User

        println("id = $id")


        boardService.update(title, content, loginUser, id)


        return "redirect:/"
    }

    @PostMapping("/delete")
    fun delete(id: Long,request: HttpServletRequest): String {

        val board = boardService.getBoardById(id)

        boardService.delete(board)



        return "redirect:/"

    }




}