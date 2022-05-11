package com.example.jpastudy.chapter2

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name="member")
@Entity
class Member(username: String, age: Int) {

    @Id
    private var id: Long? = null

    @Column(name = "name")
    private var username: String = username

    private var age: Int = age

}
