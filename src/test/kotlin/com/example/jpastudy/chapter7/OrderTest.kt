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
        val order = Order("치킨")
        em.persist(order)
        em.flush()
        println("-------------check point-----------------")

        order.menuName="피자"
        em.flush()
    }
}
