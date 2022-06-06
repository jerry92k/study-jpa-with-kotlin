package com.example.jpastudy.chapter2

import javax.persistence.*

@Entity
@NamedQuery(
    name = "Member.findByUsername",
    query = "select m from Member m where m.username = :username")
class Member(username: String, age: Int) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Column(name = "name")
    var username: String = username

    private var age: Int = age

}
