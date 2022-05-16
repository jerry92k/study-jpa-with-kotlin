package com.example.jpastudy.chapter2

import javax.persistence.*

@Table(name="member")
@Entity
class Member(username: String, age: Int) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Column(name = "name")
    private var username: String = username

    private var age: Int = age

}
