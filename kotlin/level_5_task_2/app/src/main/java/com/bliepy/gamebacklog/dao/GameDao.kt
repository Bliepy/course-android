package com.bliepy.gamebacklog.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bliepy.gamebacklog.model.GameEntity

@Dao
interface GameDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(game: GameEntity)

    @Delete
    fun delete(game: GameEntity)

    @Query("DELETE FROM table_game")
    fun deleteAll()

    @Query("SELECT * FROM table_game ORDER BY game_date ASC")
    fun list(): LiveData<List<GameEntity>>
}