package com.example.jpastudy.chapter4

import lombok.Getter
import javax.persistence.*

@Getter
@Table(name="your_school")
@Entity(name="my_school")
class School(name: String) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val name: String = name

    @Lob
    val image: Array<Byte> = arrayOf()

    @Lob
    var content: String =""
}
