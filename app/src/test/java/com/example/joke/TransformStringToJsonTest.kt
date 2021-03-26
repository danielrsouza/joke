package com.example.joke

import com.example.joke.model.Joke
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.json.JSONObject
import org.junit.Test

class TransformStringToJsonTest {
    @Test
    fun transformStringToJsonTest() {
        var joke = Joke("testing").toString()
        val responseObjectJson = JSONObject(joke)
        assertNotNull(responseObjectJson)
    }
}