package com.bliepy.bucketlistapp.store;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class BucketlistRepository {

    private BucketlistDao dao;
    private LiveData<List<BucketlistModel>> list;

    public BucketlistRepository(Context context) {
        DatabaseUtil db = DatabaseUtil.getDatabase(context);
        dao = db.bucketlistDao();
        list = dao.getAllLive();
    }

    public LiveData<List<BucketlistModel>> getAll() {
        if (list == null) {
            list = new MutableLiveData<>();
        }
        return list;
    }

    public void insert (BucketlistModel model) {
        new insertAsyncTask(dao).execute(model);
    }

    public void update (BucketlistModel model) {
        new updateAsyncTask(dao).execute(model);
    }

    public void delete (BucketlistModel GameBacklog) {
        new deleteAsyncTask(dao).execute(GameBacklog);
    }

    private static class insertAsyncTask extends AsyncTask<BucketlistModel, Void, Void> {

        private BucketlistDao mAsyncTaskDao;

        insertAsyncTask(BucketlistDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final BucketlistModel... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<BucketlistModel, Void, Void> {

        private BucketlistDao mAsyncTaskDao;

        deleteAsyncTask(BucketlistDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final BucketlistModel... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }


    private static class updateAsyncTask extends AsyncTask<BucketlistModel, Void, Void> {

        private BucketlistDao mAsyncTaskDao;

        updateAsyncTask(BucketlistDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final BucketlistModel... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
