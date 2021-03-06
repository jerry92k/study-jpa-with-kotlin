package com.example.jpastudy.chapter15

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import javax.persistence.EntityManager

@ActiveProfiles("test")
@SpringBootTest
internal class CoffeeServiceTest {

    @Autowired
    lateinit var coffeeService: CoffeeService

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test() {
        coffeeService.saveSameCoffeeTwice("Americano", "blended")

        val findCoffee = em.find(Coffee::class.java, "Americano")
        println(findCoffee)

    }

    @Test
    fun test2() {
        val id = "COFFEE_01"
        em.persist(Coffee(id,"Americano"))

        val proxyEntity = em.getReference(Coffee::class.java, id)
        val originEntity = em.find(Coffee::class.java, id)

        println("proxyEntity type ${proxyEntity.javaClass}")
        println("originEntity type ${originEntity.javaClass}")

        Assertions.assertThat(proxyEntity == originEntity).isTrue
    }

    @Test
    fun test3() {
        val id = "COFFEE_01"
        em.persist(Coffee(id,"Americano"))

        val proxyEntity = em.getReference(Coffee::class.java, id)
        val originEntity = em.find(Coffee::class.java, id)

        println("proxyEntity type ${proxyEntity.javaClass}")
        println("originEntity type ${originEntity.javaClass}")

        Assertions.assertThat(proxyEntity == originEntity).isTrue
    }
}
