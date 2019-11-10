package bliepy.com.android_level_4.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GameBacklogDao {

    @Query("SELECT * FROM backlog")
    public List<GameBacklogModel> getAll();

    @Insert
    public void insertBacklog(GameBacklogModel reminders);

    @Delete
    public void deleteBacklog(GameBacklogModel reminders);

    @Update
    public void updateBacklog(GameBacklogModel reminders);
}


