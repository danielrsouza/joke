package com.example.joke

import com.example.joke.interfaces.Constants
import junit.framework.Assert.assertEquals
import org.junit.Test

class ConstantTest {
    @Test
    fun validaConstanteTest()
    {
        assertEquals("https://api.chucknorris.io/jokes/random", Constants.urlApi)
    }
}