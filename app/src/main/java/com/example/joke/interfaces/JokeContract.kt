package com.example.joke.interfaces

import com.example.joke.model.Joke

interface JokeContract {
    interface View {

        fun showSuccess(message: String)
        fun showError(message: String)
        fun showLoading()
        fun disableLoading()
        fun openJokeList(joke: String);
    }

    interface Presenter {
        fun getJoke()
    }
}