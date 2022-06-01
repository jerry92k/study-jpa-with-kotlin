package com.example.jpastudy.chapter9

import javax.persistence.*

@Entity
class User(

    var name: String,

    @Embedded
    @AttributeOverrides(
        value = [
            AttributeOverride(name = "city", column = Column(name = "HOME_CITY")),
            AttributeOverride(name = "street", column = Column(name = "HOME_STREET")),
            AttributeOverride(name = "zipcode", column = Column(name = "HOME_ZIPCODE"))
        ]
    )
    var homeAddress: Address,

    @Embedded
    @AttributeOverrides(
        value = [
            AttributeOverride(name = "city", column = Column(name = "COMPNAY_CITY")),
            AttributeOverride(name = "street", column = Column(name = "COMPNAY_STREET")),
            AttributeOverride(name = "zipcode", column = Column(name = "COMPNAY_ZIPCODE"))]
    )
    var companyAddress: Address

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}
