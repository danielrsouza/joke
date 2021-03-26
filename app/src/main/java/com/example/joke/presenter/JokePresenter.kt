package com.example.joke.presenter

import androidx.appcompat.app.AlertDialog
import com.example.joke.http.HttpHelper
import com.example.joke.interfaces.JokeContract
import com.example.joke.interfaces.JokeContract.View
import com.example.joke.model.Joke
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject

class JokePresenter: JokeContract.Presenter {
    lateinit var view: JokeContract.View
    private val httpHelper = HttpHelper()

    override fun getJoke() {
        view.showLoading();

        doAsync{
            var resposta = httpHelper.getJoke()
            var respostaObjJson = JSONObject(resposta);

            var joke = Joke(respostaObjJson.getString("icon_url"),
                respostaObjJson.getString("id"),
                respostaObjJson.getString("url"),
                respostaObjJson.getString("value")
            )

            uiThread {
                println(joke);
                view.disableLoading()
            }
        }



    }
}