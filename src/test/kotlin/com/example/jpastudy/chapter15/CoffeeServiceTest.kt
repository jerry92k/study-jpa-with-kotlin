package com.example.jpastudy.chapter15

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import javax.persistence.EntityManager
import javax.persistence.LockTimeoutException
import javax.persistence.NoResultException
import javax.persistence.NonUniqueResultException
import javax.persistence.QueryTimeoutException

@ActiveProfiles("test")
@SpringBootTest
internal class CoffeeServiceTest{

    @Autowired
    lateinit var coffeeService: CoffeeService

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test(){
        coffeeService.saveSameCoffeeTwice("Americano","blended")

        val findCoffee = em.find(Coffee::class.java, "Americano")
        println(findCoffee)

    }
}
