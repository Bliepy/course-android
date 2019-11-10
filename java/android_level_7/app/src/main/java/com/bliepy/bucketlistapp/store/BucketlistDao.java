package com.bliepy.bucketlistapp.store;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BucketlistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(BucketlistModel reminders);

    @Delete
    public void delete(BucketlistModel reminders);

    @Update
    public void update(BucketlistModel reminders);

    @Query("DELETE FROM bucket")
    void deleteAll();

    @Query("SELECT * from bucket")
    List<BucketlistModel> getAll();

    @Query("SELECT * from bucket")
    LiveData<List<BucketlistModel>> getAllLive();
}


