package com.bliepy.rockpaperscissors.database

import android.content.Context

class GameRepository(context: Context) {


    private var gameDao: GameDao

    init {

        val gameDatabase = GameDatabase.getDatabase(context)
        gameDao = gameDatabase.gameDao()

    }

    suspend fun getAllGames(): List<GameModel> {
        return gameDao.getAll()
    }

    suspend fun saveGame( game : GameModel)  {
        return gameDao.insert(game)
    }

    suspend fun deleteAll( )  {
        return gameDao.delete()
    }

}