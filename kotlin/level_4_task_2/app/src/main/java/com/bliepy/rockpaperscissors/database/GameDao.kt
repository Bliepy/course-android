package com.bliepy.rockpaperscissors.database

import androidx.room.*

@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    suspend fun getAll(): List<GameModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(game: GameModel)


    @Query("DELETE FROM game")
    suspend fun delete()
}