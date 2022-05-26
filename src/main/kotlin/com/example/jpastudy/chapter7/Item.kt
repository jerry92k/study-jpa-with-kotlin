package com.example.jpastudy.chapter7

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Item(var name: String, var price: Int) {

    @Id
    @GeneratedValue
    var id: Long? = null
}

@Entity
class Album(var artist: String, name: String, price: Int) : Item(name, price)


@Entity
class MusicVideo(var director: String, var actor: String, name: String, price: Int) : Item(name, price)
