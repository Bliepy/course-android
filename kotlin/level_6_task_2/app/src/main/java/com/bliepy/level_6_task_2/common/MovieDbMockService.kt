package com.bliepy.level_6_task_2.common

import java.io.File


class MovieDbMockService {

    fun getMockedJsonResponse(path:String) : String{
        return when(path){
            "/3/discover/movie" -> searchByYearMovies()
            "/3/list/" -> getMovie()
            else -> ""
        }
    }
    //https://api.themoviedb.org/3/discover/movie?api_key=b6b5001206a168a8cd9a2f48dcc5435c&sort_by=release_date.desc&primary_release_year=2020
    private fun searchByYearMovies(): String {
        return File("movie-list.json").readText(Charsets.UTF_8)
    }

    //https://api.themoviedb.org/3/movie/157438?api_key=b6b5001206a168a8cd9a2f48dcc5435c
    private fun getMovie(): String {
        return File("movie.json").readText(Charsets.UTF_8)
    }

}