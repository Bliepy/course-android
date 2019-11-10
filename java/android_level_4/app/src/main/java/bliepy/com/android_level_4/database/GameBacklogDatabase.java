package bliepy.com.android_level_4.database;

import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {GameBacklogModel.class}, version = 17, exportSchema = false)
public abstract class GameBacklogDatabase extends RoomDatabase {


    private final static String NAME_DATABASE = "gamebacklog_dbm";
    private static GameBacklogDatabase backlogInstance;

    public abstract GameBacklogDao gameBacklogDao();

    public static GameBacklogDatabase getInstance(Context context) {

        if(backlogInstance == null) {
            backlogInstance = Room.databaseBuilder(context.getApplicationContext(), GameBacklogDatabase.class, NAME_DATABASE)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return backlogInstance;
    }
}
