package com.example.joke.presenter

import com.example.joke.http.HttpHelper
import com.example.joke.interfaces.JokeContract
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class JokePresenter: JokeContract.Presenter {
    lateinit var view: JokeContract.View
    private val httpHelper = HttpHelper()
    val messageSuccess = "Consulta feita com sucesso!"
    val messageError = "Consulta não teve sucesso!"

    override fun getJoke()  {
        // Habilita o loading na tela
        view.showLoading();

        try {
            //Código que acontece em background
            doAsync {
                val responseApi = httpHelper.getJoke()

                //Código que acontece após o termino da request
                uiThread {
                    view.disableLoading()
                    view.showSuccess(messageSuccess)
                    view.openJokeList(responseApi);
                }
            }
        }catch(e : Exception) {
            view.showError(messageError)
            throw Exception(e.message);
        }
    }


}