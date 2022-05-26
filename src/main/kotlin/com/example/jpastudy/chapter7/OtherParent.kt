package com.example.jpastudy.chapter7

import javax.persistence.*

@Entity
class OtherParent {

    @Id
    var id: String? = null

    @ManyToOne
    @JoinColumns(value = [
        JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),
        JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
    ])
    var parent: Parent? = null
}
