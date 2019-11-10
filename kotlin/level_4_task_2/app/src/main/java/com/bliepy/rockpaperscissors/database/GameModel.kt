package com.bliepy.rockpaperscissors.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameModel(

    @PrimaryKey(autoGenerate = true) var uid: Int?,
    @ColumnInfo(name = "computer") var computer: Int?,
    @ColumnInfo(name = "user") var user: Int?,
    @ColumnInfo(name = "state") var state: String?,
    @ColumnInfo(name = "timestamp") var timestamp: String?
)

