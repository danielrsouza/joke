package com.example.joke.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.joke.R
import com.example.joke.model.Joke


class JokeListAdapter(var mContext:Context, var resources: Int, var item: List<Joke>) : ArrayAdapter<Joke>(mContext, resources, item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        // Trata de receber meu contexto e inflar minha lista
        val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)
        val view: View = layoutInflater.inflate(resources, null)

        //Joke value, piada descrita na rowList. Recuperando o TextView da mesma
        val jokeValue: TextView = view.findViewById(R.id.textJoke)

        //Pega o item da minha lista pela position e atribui o valor no TextView.
        val mItem: Joke = item[position]
        jokeValue.text = mItem.value

        return view
    }
}