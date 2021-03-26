package com.example.joke.interfaces

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