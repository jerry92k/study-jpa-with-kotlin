package com.example.jpastudy.chapter6

import javax.persistence.*

@Entity
class Resident(
    val name: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parking_lot_id", nullable = false)
    var parkingLot: ParkingLot
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}
