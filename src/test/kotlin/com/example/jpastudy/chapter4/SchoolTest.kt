package com.example.jpastudy.chapter4

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest
internal class SchoolTest{

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test(){
        val school = School("dudu")
        em.persist(school)
        em.flush()
    }
}
