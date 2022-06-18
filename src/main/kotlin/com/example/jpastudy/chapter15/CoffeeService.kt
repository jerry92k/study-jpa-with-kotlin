package com.example.jpastudy.chapter15

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityExistsException
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Service
class CoffeeService {

    @Autowired
    lateinit var em: EntityManager

    @Transactional
    fun saveSameCoffeeTwice(id: String, name: String){
        em.persist(Coffee(id,name))
        try {
            em.persist(Coffee(id,name))
        }catch (ex: EntityExistsException){
            println("EntityExistsException occured")

        }
    }
}
