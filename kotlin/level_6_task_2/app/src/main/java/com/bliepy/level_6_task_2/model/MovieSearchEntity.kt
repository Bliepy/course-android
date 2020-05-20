package com.bliepy.level_6_task_2.model

import com.google.gson.annotations.SerializedName

data class MovieSearchEntity(

    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("poster_path")
    var poster_path: String
)


