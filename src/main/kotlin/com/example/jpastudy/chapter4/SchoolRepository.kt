package com.example.jpastudy.chapter4

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.data.repository.query.Param


interface SchoolRepository : JpaRepository<School, Long>, SchoolRepositoryCustom {

    @Query("select s from my_school s where s.name='abc'")
    fun findBySchoolName(): School

    @Modifying
    @Query("update my_school s set s.content=:content")
    fun updateContent(@Param("content") content: String)

    @Query("select s from my_school s")
    fun findSchoolsWithPaging(pageable: Pageable): Page<School>

    @Query("select s from my_school s")
    fun findSchoolsWithPagingWithoutCount(pageable: Pageable): List<School>

    @Query("select s from my_school s")
    fun findSchoolsWithSort(sort: Sort): List<School>
}

interface SchoolRepositoryCustom {
    fun findSchoolCustom(): List<School>
}

class SchoolRepositoryImpl : SchoolRepositoryCustom, QuerydslRepositorySupport {

    constructor(domainClass: Class<*>) : super(domainClass)

    override fun findSchoolCustom(): List<School> {
        TODO("Not yet implemented")
    }
}
