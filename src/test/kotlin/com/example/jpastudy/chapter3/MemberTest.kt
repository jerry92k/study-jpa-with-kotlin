package com.example.jpastudy.chapter3

import com.example.jpastudy.chapter2.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest
internal class MemberTest{

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun 엔티티를_영속화한다(){
        val member = Member("gigi",31)
        em.persist(member)
    }

    @Test
    fun 엔티티_생명주기(){
        // 객체를 생성(비영속)
        val member = Member("gigi",31)

        // 객체를 영속성 컨텍스트에 저장(영속)
        em.persist(member)
        em.flush()

        // 준영속 상태로 변경
        em.detach(member)

        // 삭제
        /**
         * 전 단계에서 detached 되었기 때문에 다시 영속화한다.
         * member 엔티티 객체는 detached 되었지만 merge하여 반환한 mergedMember 엔티티 객체는 영속화되었다.
         * 두 개의 인스턴스가 다르다.
         */
        val mergedMember = em.merge(member)
        println(member)
        println(mergedMember)
        Assertions.assertThat(member!=mergedMember).isTrue()
    }

    @Test
    fun 동일성_보장(){
        val member = Member("gigi",31)
        em.persist(member)

        val findMember1 = em.find(Member::class.java, 1L)
        val findMember2 = em.find(Member::class.java, 1L)

        Assertions.assertThat(findMember1==findMember2).isTrue()
    }
}
