package com.example.jpastudy.chapter6

import org.assertj.core.api.Assertions

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import javax.persistence.EntityManager

@DataJpaTest
internal class ResidentTest{

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun 연관관계_설정_확인(){
        val parkingLot = ParkingLot("A-24")
        em.persist(parkingLot)

        val resident = Resident("gigi",parkingLot)
        em.persist(resident)
        em.flush()
        em.clear()

        val findResident = em.find(Resident::class.java, resident.id)
        println("---- check point ----")
        val referParkingLog = findResident.parkingLot
        println("referParkingLog name : ${referParkingLog.sectionName}")
        Assertions.assertThat(referParkingLog.sectionName).isEqualTo(parkingLot.sectionName)
    }

    @Test
    fun 양방향_연관관계_영속화(){
        val parkingLot = ParkingLot("A-24")
        em.persist(parkingLot)

        val resident = Resident("gigi",parkingLot)
        parkingLot.occupiedBy(resident)
        em.persist(resident)
        em.flush()
        em.clear()

        val findParkingLot = em.find(ParkingLot::class.java, resident.id)
        println("---- check point ----")
        val referResident = findParkingLot.resident
        println("referResident name : ${referResident?.name}")
        Assertions.assertThat(referResident?.name).isEqualTo(resident.name)
    }
}
