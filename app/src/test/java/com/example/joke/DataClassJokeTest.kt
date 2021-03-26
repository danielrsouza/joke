package com.example.joke

import com.example.joke.model.Joke
import junit.framework.Assert.assertEquals
import org.junit.Test

class DataClassJokeTest {
    @Test
    fun dataClassJokeTest()
    {
        val joke = Joke("teste")
        assertEquals("teste", joke.value)
    }
}