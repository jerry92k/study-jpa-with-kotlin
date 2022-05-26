package com.example.jpastudy.chapter7

import javax.persistence.*

@Entity(name = "orders")
class Order(var menuName: String) : BaseEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}
