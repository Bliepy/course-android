package com.bliepy.level_6_task_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bliepy.level_6_task_2.adapter.MovieAdapter
import com.bliepy.level_6_task_2.common.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private var movieAdapter: MovieAdapter? = null
    private var movieRecyclerView : RecyclerView? = null
    private var movieViewModel : MovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        movieRecyclerView = findViewById(R.id.recyclerView)
        movieRecyclerView?.layoutManager = GridLayoutManager(this, 2)
        movieViewModel  = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        val yearEditText : EditText = findViewById(R.id.inputTextSearchYear)
        val searchActionButton : Button = findViewById(R.id.buttonSearchYear)

        movieViewModel!!.movies.observe(this, Observer { data ->

        movieAdapter = MovieAdapter(data){

            val intent  = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
            movieRecyclerView?.adapter = movieAdapter
            movieAdapter?.notifyDataSetChanged()
        })

        searchActionButton.setOnClickListener{
            val year : String = yearEditText.text.toString()
                movieViewModel!!.getMovieList(year)
                movieAdapter?.notifyDataSetChanged()
            }
    }
}


