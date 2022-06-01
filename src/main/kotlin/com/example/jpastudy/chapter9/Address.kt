package com.example.jpastudy.chapter9

import javax.persistence.Embeddable

@Embeddable
class Address(

    var city: String,

    var street: String,

    var zipcode: String
)
