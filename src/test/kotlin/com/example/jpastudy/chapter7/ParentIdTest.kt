package com.example.jpastudy.chapter7

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest
internal class ParentIdTest{


    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test(){
        val parent = Parent()
        parent.name="gigi"
        parent.id=ParentId("id1", "id2")
        em.persist(parent)
        em.flush()
        em.clear()

        val parentId = ParentId("id1","id2")
        val findParent = em.find(Parent::class.java, parentId)
        println(findParent)

        Assertions.assertThat(parent).isEqualTo(findParent)
    }
}
