package com.bliepy.gamebacklog.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bliepy.gamebacklog.common.DatabaseUtil
import com.bliepy.gamebacklog.dao.GameDao
import com.bliepy.gamebacklog.model.GameEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private var gameList: LiveData<List<GameEntity>>
    private var dao: GameDao

    init {
        val database =
            DatabaseUtil.getDatabase(
                application
            )
        dao = database?.gameDao()!!
        gameList = dao.list()
    }

    fun getGameList(): LiveData<List<GameEntity>> {
        return gameList
    }

    fun removeGame(gameEntity: GameEntity) {
        GlobalScope.launch {
            dao.delete(gameEntity)
        }
    }

    fun removeAllGames() {
        GlobalScope.launch {
            dao.deleteAll()
        }
    }

    fun createGame(gameEntity: GameEntity) {
        GlobalScope.launch {
            dao.insert(gameEntity)
        }
    }
}