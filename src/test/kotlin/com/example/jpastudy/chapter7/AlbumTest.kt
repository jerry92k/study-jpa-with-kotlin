package com.example.jpastudy.chapter7

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest
internal class AlbumTest{

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun test(){
        val movie = MusicVideo(director = "gigi","gigi-k", name = "movie-1",12000)
        val album = Album(artist = "gigi","album-1",5000)

        em.persist(movie)
        em.persist(album)
        em.flush()
    }
}
