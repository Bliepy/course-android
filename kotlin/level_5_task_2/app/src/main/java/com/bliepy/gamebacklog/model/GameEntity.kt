package com.bliepy.gamebacklog.model

import androidx.room.*

@Entity(tableName = "TABLE_GAME")
data class GameEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0L,

    @ColumnInfo(name = "game_title")
    var title: String? = "",

    @ColumnInfo(name = "game_platform")
    var platform: String? = "",

    @ColumnInfo(name = "game_date")
    var date: Long

)

