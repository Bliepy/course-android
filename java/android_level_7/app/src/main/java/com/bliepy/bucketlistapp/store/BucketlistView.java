package com.bliepy.bucketlistapp.store;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import java.util.List;

public class BucketlistView extends ViewModel {

    private BucketlistRepository repository;
    private LiveData<List<BucketlistModel>> list;

    public BucketlistView(Context context) {
        repository = new BucketlistRepository(context);
        list = repository.getAll();
    }

    public LiveData<List<BucketlistModel>> list() {
        return list;
    }

    public void insert(BucketlistModel model) {
        repository.insert(model);
    }

    public void update(BucketlistModel model) {
        repository.update(model);
    }

    public void delete(BucketlistModel model) {
        repository.delete(model);
    }

}
