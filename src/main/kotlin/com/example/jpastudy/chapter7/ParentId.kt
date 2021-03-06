package com.example.jpastudy.chapter7

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ParentId(

    @Column(name="PARENT_ID1")
    var id1: String?=null,

    @Column(name="PARENT_ID2")
    var id2: String?=null
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ParentId

        if (id1 != other.id1) return false
        if (id2 != other.id2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id1?.hashCode() ?: 0
        result = 31 * result + (id2?.hashCode() ?: 0)
        return result
    }
}
