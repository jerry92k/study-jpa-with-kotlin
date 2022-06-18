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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Coffee) return false

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

}
