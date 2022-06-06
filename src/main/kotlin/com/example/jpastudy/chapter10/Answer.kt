package com.example.jpastudy.chapter10

import javax.persistence.*

@Entity
class Answer(val content:String,
             @JoinColumn(name = "quetion_id")
             @ManyToOne
             val question: Question) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null
}
