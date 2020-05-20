package com.bliepy.level_6_task_2.common

import com.bliepy.level_6_task_2.model.MovieEntity
import com.bliepy.level_6_task_2.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbService {

    @GET("/3/movie/popular")
    suspend fun searchYear(
        @Query("sort_by") sort_by:String? = "favorite_count.desc" ,
        @Query("primary_release_year") primary_release_year: String): MovieResponse

    @GET("/3/movie/{list_id}")
    suspend fun getMovie(
        @Path("list_id") list_id: String ): MovieEntity
}