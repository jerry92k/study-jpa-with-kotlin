package com.example.jpastudy.chapter15

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Coffee (

    @Id
    var id: String,

    var name: String
) {

    override fun toString(): String {
        return "Coffee(id='$id', name='$name')"
    }
}
