package com.bliepy.bucketlistapp.store;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "bucket")
public class BucketlistModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "bucket_item")
    private String bucketItem;
    @ColumnInfo(name = "bucket_group")
    private String bucketGroup;
    @ColumnInfo(name = "bucket_group_postion")
    private int bucketGroupPosition;
    @ColumnInfo(name = "done")
    private boolean done;
    @ColumnInfo(name = "done_position")
    private boolean donePosition;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getBucketItem() {
        return bucketItem;
    }

    public void setBucketItem(String bucketItem) {
        this.bucketItem = bucketItem;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getBucketGroup() {
        return bucketGroup;
    }

    public void setBucketGroup(String bucketGroup) {
        this.bucketGroup = bucketGroup;
    }

    public int getBucketGroupPosition() {
        return bucketGroupPosition;
    }

    public void setBucketGroupPosition(int bucketGroupPosition) {
        this.bucketGroupPosition = bucketGroupPosition;
    }

    public boolean isDonePosition() {
        return donePosition;
    }

    public void setDonePosition(boolean donePosition) {
        this.donePosition = donePosition;
    }
}
