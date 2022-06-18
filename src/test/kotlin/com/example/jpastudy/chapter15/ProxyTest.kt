package com.example.jpastudy.chapter15

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager


@DataJpaTest
class ProxyTest {

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test1() {
        val id = "COFFEE_01"
        em.persist(Coffee(id,"Americano"))
        em.flush()
        em.clear()

        val proxyEntity = em.getReference(Coffee::class.java, id)
        val originEntity = em.find(Coffee::class.java, id)

        println("proxyEntity type ${proxyEntity.javaClass}")
        println("originEntity type ${originEntity.javaClass}")

        assertThat(proxyEntity == originEntity).isTrue
    }

    @Test
    fun test2() {
        val id = "COFFEE_01"
        em.persist(Coffee(id,"Americano"))
        em.flush()
        em.clear()

        val originEntity = em.find(Coffee::class.java, id)
        val proxyEntity = em.getReference(Coffee::class.java, id)

        println("proxyEntity type ${proxyEntity.javaClass}")
        println("originEntity type ${originEntity.javaClass}")

        assertThat(proxyEntity == originEntity).isTrue
    }
}

