package com.bliepy.bucketlistapp.store;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {BucketlistModel.class}, version = 2, exportSchema = false)
public abstract class DatabaseUtil extends RoomDatabase {


    private final static String NAME_DATABASE = "bucketlist.db";

    public abstract BucketlistDao bucketlistDao();

    private static volatile DatabaseUtil INSTANCE;

    public static DatabaseUtil getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseUtil.class) {
                INSTANCE = Room.databaseBuilder(context,
                        DatabaseUtil.class, NAME_DATABASE)
//                         .addCallback(stubdata)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }

    public static void closeConnection(){
        INSTANCE.close();
    }

    private static RoomDatabase.Callback stubdata =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new DatabasePopulation(INSTANCE).execute();
                }
            };
}
