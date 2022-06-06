package com.example.jpastudy.chapter10

import javax.persistence.*

@Entity
class Question(val content: String) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null

    @OneToMany(mappedBy = "question", cascade = [CascadeType.PERSIST, CascadeType.MERGE], orphanRemoval = true)
    val answers: List<Answer> = listOf()
}
