package com.bliepy.level_6_task_2.common


class MovieRepository {

    var client: MovieDbService = ApiFactory.webservice

    suspend fun getMovieList(year: String) = client.searchYear(primary_release_year = year).results
    suspend fun getMovieList() = client.searchYear(primary_release_year = "2020").results
    suspend fun getMovie(list_id: String) = client.getMovie(list_id)

}