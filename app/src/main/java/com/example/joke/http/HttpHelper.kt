package com.example.joke.http

import com.example.joke.interfaces.Constants
import com.google.gson.Gson
import org.json.JSONArray
import java.net.URL

class HttpHelper {
    val urlApi = Constants.urlApi
    private val convertJson = Gson()


    fun getJoke(): String {
        val respostaConsulta = URL(urlApi).readText()

        return respostaConsulta
    }
}