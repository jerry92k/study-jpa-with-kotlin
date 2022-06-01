package com.example.jpastudy.chapter9

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest
internal class UserTest {

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test() {
        val user = User(
            name = "gigi",
            companyAddress = Address("seoul", "gangnam", "32143"),
            homeAddress = Address("yongin", "suzi", "25345")
        )
        em.persist(user)
        em.flush()
    }
}
