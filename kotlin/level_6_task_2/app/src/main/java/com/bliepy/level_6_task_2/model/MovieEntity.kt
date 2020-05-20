package com.bliepy.level_6_task_2.model

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id")
    var id: String,
    @SerializedName("original_title")
    var original_title: String,
    @SerializedName("release_date")
    var release_date: String,
    @SerializedName("vote_average")
    var vote_average: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("poster_path")
    var poster_path: String
)


