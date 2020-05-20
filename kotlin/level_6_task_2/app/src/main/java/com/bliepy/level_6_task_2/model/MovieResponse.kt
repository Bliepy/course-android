package com.bliepy.level_6_task_2.model

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("page")
    var page: Long ,
    @SerializedName("total_results")
    var total_results: Long ,
    @SerializedName("total_pages")
    var total_pages: Long ,
    @SerializedName("results")
    var results : List<MovieSearchEntity>)

