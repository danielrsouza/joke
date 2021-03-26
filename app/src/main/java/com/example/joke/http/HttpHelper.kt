package com.example.joke.http

import com.example.joke.interfaces.Constants
import java.net.URL

class HttpHelper {
    // Recebe o endereço da API
    val urlApi = Constants.urlApi

    fun getJoke(): String {
        return URL(urlApi).readText()
    }
}