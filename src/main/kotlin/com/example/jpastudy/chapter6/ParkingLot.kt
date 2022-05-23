package com.example.jpastudy.chapter6

import javax.persistence.*

@Entity
class ParkingLot(val sectionName: String) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    @OneToOne(mappedBy = "parkingLot", fetch = FetchType.LAZY)
    var resident: Resident? =null

    fun occupiedBy(resident: Resident){
        this.resident=resident
    }
}
