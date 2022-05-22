package com.example.jpastudy.chapter5

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Screen(

    @JoinColumn(name = "movie_id")
    @ManyToOne(fetch = FetchType.LAZY)
    val movie: Movie,

    val time: LocalDateTime
    ) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
