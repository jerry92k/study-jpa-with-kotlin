package com.example.jpastudy.chapter10

import com.example.jpastudy.chapter2.Member
import com.example.jpastudy.chapter4.School
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager
import javax.persistence.FlushModeType
import javax.persistence.Query
import javax.persistence.TypedQuery

@DataJpaTest
class JpqlTest {

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test() {
        val username = "gigi";
        em.persist(Member(username, 31))
        em.flush();

        val unclearTypeJpql = "select m.username, m.age from Member as m where m.username = '${username}'"
        val query = em.createQuery(unclearTypeJpql)
        val result = query.resultList[0] as Array<Any>
        assertThat(result[0].toString()).isEqualTo(username)

        val clearTypeJpql = "select m from Member as m where m.username = '${username}'"
        val typeQuery: TypedQuery<Member> = em.createQuery(clearTypeJpql, Member::class.java)

        val resultList = typeQuery.resultList
        assertThat(resultList[0].username).isEqualTo(username)
    }

    @Test
    fun test2() {
        val username = "gigi";
        em.persist(Member(username, 31))
        em.flush();

        val clearTypeJpql = "select m from Member as m " +
                "where m.username = :username"
        val query = em.createQuery(clearTypeJpql, Member::class.java)
        val results = query.setParameter("username", username) // 첫번째 파라미터 문자열은 :으로 지정한 파라미터명과 같아야 한다.
            .resultList

    }

    @Test
    fun test3() {
        val username = "gigi";
        em.persist(Member(username, 31))
        em.flush();

        val clearTypeJpql = "select m from Member as m " +
                "where m.username = ?1"
        val query = em.createQuery(clearTypeJpql, Member::class.java)
        val results = query.setParameter(1, username) // 첫번째 파라미터 문자열은 :으로 지정한 파라미터명과 같아야 한다.
            .resultList
    }

    @Test
    fun test4() {
        val username = "gigi";
        em.persist(Member(username, 31))
        em.flush();

        val query: Query = em.createQuery(
            "select new com.example.jpastudy.chapter10.UserDTO(m.username, m.age) from Member m",
            UserDTO::class.java
        )
        val result: List<UserDTO> = query.resultList as List<UserDTO>
    }

    @Test
    fun test_updateBulk() {
        em.createQuery("update Member m set m.username = concat('super ',m.username) where m.age > 30")
    }

    @Test
    fun test_insertBulk() {
        em.createQuery(
            "insert into Member(username, age) " +
                    "select u.name, u.age from User u where u.age > 20"
        )
    }

    @Test
    fun test_flush() {
        val member = Member("gigi", 31)
        em.persist(member)
        val school = School(name = "testSchool")
        em.persist(school)
        em.flush()
        school.content = "changed"

        val findMember = em.createQuery("select m from Member m")
            .setFlushMode(FlushModeType.AUTO) // FlushModeType.AUTO 가 default 값이다.
            .singleResult as Member

    }

    @Test
    fun test_join() {
        em.createQuery(
            "select m from Member m " +
                    "inner join m.team t " +
                    "where t.name = :teamName", Member::class.java
        ).setParameter("teamName", "Ateam")

    }

    @Test
    fun fetchjoin(){
        val question = Question("question")
        em.persist(question)
        em.persist(Answer("test1",question))
        em.persist(Answer("test2",question))
        em.persist(Answer("te3",question))
        em.persist(Answer("te4",question))

        val findQuestion = em.createQuery(
            "select q from Question q join fetch q.answers a on a.content ='test1'",
            Question::class.java
        ).resultList
        findQuestion.forEach {
            it.answers.forEach { println(it.content) }
        }
    }

    @Test
    fun namedQuery(){
        em.createNamedQuery("Member.findByUsername",Member::class.java)
            .setParameter("username","gigi")
            .resultList
    }

}
