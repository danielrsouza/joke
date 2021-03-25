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

        // TODO - VERIFICAR O PORQUE NÃO ESTÁ FUNCIONANDO O btnJoke.setOnClickListener (Synthetic)

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
        TODO("Not yet implemented")
    }
}