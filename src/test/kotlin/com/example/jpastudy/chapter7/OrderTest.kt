package com.example.jpastudy.chapter7

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest
internal class OrderTest{

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test(){
        val orders = Orders("치킨")
        em.persist(orders)
        em.flush()
        println("-------------check point-----------------")

        orders.menuName="피자"
        em.flush()
    }
}
