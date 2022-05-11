package com.example.jpastudy.chapter2

import javax.persistence.EntityManager
import javax.persistence.EntityTransaction
import javax.persistence.PersistenceContext

class TransactionMain {

    @PersistenceContext
    lateinit var em: EntityManager

    fun doTransaction(){
        val tx = em.transaction

        try{
            tx.begin()
            // something
            tx.commit()
        }catch (ex: Exception){
            tx.rollback()
        }
    }

}


