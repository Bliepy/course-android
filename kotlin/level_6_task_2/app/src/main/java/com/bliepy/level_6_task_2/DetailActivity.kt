package com.bliepy.level_6_task_2

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bliepy.level_6_task_2.common.MovieViewModel
import com.bliepy.level_6_task_2.model.MovieEntity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    private var movieViewModel : MovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val bundle :Bundle ?=intent.extras
        val id = bundle!!.getString("id")
        Log.d("MOVIE ID", "$id")

        movieViewModel  = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        var movie  = Observer<MovieEntity>{ movie->
            var imageBanner : ImageView =  findViewById(R.id.imageBanner)
            var imagePoster : ImageView =   findViewById(R.id.imagePoster)
            var textTitle : TextView =  findViewById(R.id.textTitle)
            var textOverview : TextView =  findViewById(R.id.textOverview)
            var textReleaseDate : TextView =  findViewById(R.id.textReleaseDate)
            var textRating : TextView =   findViewById(R.id.textRating)

            textTitle.text = movie.original_title
        }

        movieViewModel!!.getMovie("$id").observe(this, movie)

    }

}
