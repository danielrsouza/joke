package com.example.joke.presenter

import com.example.joke.interfaces.JokeContract
import com.example.joke.interfaces.JokeContract.View

class JokePresenter: JokeContract.Presenter {
    lateinit var view: JokeContract.View

    override fun getJoke() {
        view.showLoading();
    }
}