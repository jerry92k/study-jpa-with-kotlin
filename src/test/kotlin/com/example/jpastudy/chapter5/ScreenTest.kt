package com.example.jpastudy.chapter5

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime
import javax.persistence.EntityManager

@DataJpaTest
internal class ScreenTest {

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test() {
        val movie = Movie("starwarz")
        em.persist(movie)

        val screen = Screen(movie, LocalDateTime.now())
        em.persist(screen)
        em.flush()

        Assertions.assertThat(movie).isEqualTo(screen.movie)

        em.clear()


        println("here")
        val findScheen = em.find(Screen::class.java, 1L)
        findScheen

        /** all-open 플러그인 선언만으로는 @Entity에 open이 적용되지 않아 lazy loading이 적용되지 않아 Movie까지 데이터를 가져온다.
         * plugins {
        kotlin("plugin.spring") version "1.6.21"
        }

        별도로 다음과 같이 설정을 해주어야 lazy-loading이 적용된다.
         * allOpen {
         *      annotation("javax.persistence.Entity")
         *  }
         */
    }
}
