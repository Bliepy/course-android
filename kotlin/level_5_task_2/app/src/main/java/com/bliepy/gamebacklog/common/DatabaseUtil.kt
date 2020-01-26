package com.bliepy.gamebacklog.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bliepy.gamebacklog.dao.GameDao
import com.bliepy.gamebacklog.model.GameEntity

@Database(entities = [GameEntity::class], version = 4, exportSchema = false)
abstract class DatabaseUtil : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAME_DATABASE_2"

        @Volatile
        private var INSTANCE: DatabaseUtil? = null

        fun getDatabase(context: Context): DatabaseUtil? {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DatabaseUtil::class.java, DATABASE_NAME
                        ).allowMainThreadQueries().fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}