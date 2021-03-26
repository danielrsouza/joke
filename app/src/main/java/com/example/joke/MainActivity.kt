package com.example.joke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.joke.interfaces.JokeContract
import com.example.joke.model.Joke
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressBar3.visibility = View.VISIBLE
        btnJoke.visibility = View.INVISIBLE
    }

    override fun disableLoading() {
        progressBar3.visibility = View.INVISIBLE
        btnJoke.visibility = View.VISIBLE
    }

    override fun openJokeList(joke: String) {
        finish()
        val intent = Intent(this, JokeActivity::class.java).apply {
            putExtra("joke", joke)
        }
        startActivity(intent)
    }

}