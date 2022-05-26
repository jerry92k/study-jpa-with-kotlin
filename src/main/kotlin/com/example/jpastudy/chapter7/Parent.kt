package com.example.jpastudy.chapter7

import javax.persistence.*

@Entity
class Parent {

    @EmbeddedId
    var id:ParentId?=null

    var name: String?=null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Parent

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
