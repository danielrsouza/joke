package com.example.joke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.example.joke.interfaces.JokeContract
import com.example.joke.presenter.JokePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), JokeContract.View {
    private val presenter = JokePresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind entre VIEW e PRESENTER
        presenter.view = this

        btnJoke.setOnClickListener {
           presenter.getJoke();
        }

    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        progressBar3.visibility = View.VISIBLE
        btnJoke.visibility = View.INVISIBLE
        println("está passando aqui");
    }

    override fun disableLoading() {
        progressBar3.visibility = View.INVISIBLE
        btnJoke.visibility = View.VISIBLE
        println("está passando aqui 2");
    }
}