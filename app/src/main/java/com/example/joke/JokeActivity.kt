package com.example.joke

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.joke.adapter.JokeListAdapter
import com.example.joke.model.Joke
import kotlinx.android.synthetic.main.activity_joke_list.*
import org.json.JSONObject


class JokeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_list)

        //Cria o botão de voltar na activity
        buttonBack()

        //Recebe dados da activity anterior e chama uma fun para transformar a string em obj
        val joke = intent.getStringExtra("joke");
        val jokeObject = transformStringToJson(joke.toString());

        //Monta lista com um Joke Object
        var listOfJoke = mutableListOf<Joke>()
        listOfJoke.add(jokeObject)

        viewList.adapter = JokeListAdapter(this, R.layout.list_row, listOfJoke)
    }
    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
        return
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            }
        }
        return true
    }

    //Transforma a string em objeto
    fun transformStringToJson(joke: String) : Joke
    {
        val responseObjectJson = JSONObject(joke)

        // Transforma a resposta string da API em um Objeto Json
        return Joke(responseObjectJson.getString("value"))
    }

    fun buttonBack()
    {
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeButtonEnabled(true)
        getSupportActionBar()?.setTitle("Joke")
    }

}