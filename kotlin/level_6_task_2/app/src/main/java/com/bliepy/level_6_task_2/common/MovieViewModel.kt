package com.bliepy.level_6_task_2.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MovieViewModel : ViewModel() {

    private var repository: MovieRepository = MovieRepository()

    val movies =
        liveData(Dispatchers.IO) {
            val movies = repository.getMovieList()
            emit(movies)
        }

    fun getMovie(id: String) =
        liveData(Dispatchers.IO) {
            val movie = repository.getMovie(id)
            emit(movie)
        }

    fun getMovieList(year: String) =
        liveData(Dispatchers.IO) {
            val movies = repository.getMovieList(year)
            emit(movies)
        }
}


