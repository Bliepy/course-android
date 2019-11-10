package com.bliepy.bucketlistapp.store;

import android.os.AsyncTask;

public class DatabasePopulation extends AsyncTask<Void, Void, Void> {

    private final BucketlistDao dao;

    DatabasePopulation(DatabaseUtil db) {
        dao = db.bucketlistDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        dao.deleteAll();
        return null;
    }
}
