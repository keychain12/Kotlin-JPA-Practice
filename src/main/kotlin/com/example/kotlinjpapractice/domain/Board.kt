package com.example.kotlinjpapractice.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "TestBoard")
class Board(
    var title: String,
    var content: String,
    val regdate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User?

) {
    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false) // 극비기 이거알면 코틀린좀친다
    val id: Long = 0


    fun update(title: String, content: String, user: User) {
        this.title = title
        this.content = content
        this.user = user

    }

}

// 엔티티는  그냥 클래스
// data 클래스는 이퀄쓰 , 해시코드 , 투스트링 다만들어준다.  @Embeddable vo 밸류오브젝트에서 는쓴다.

