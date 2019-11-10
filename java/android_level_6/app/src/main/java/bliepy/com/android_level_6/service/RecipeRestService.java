package bliepy.com.android_level_6.service;

import bliepy.com.android_level_6.model.RecipeModel;
import bliepy.com.android_level_6.model.RecipeSearchResultModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeRestService {
    @GET("search")
    Call<RecipeSearchResultModel> search(@Query("q") String search,
                                         @Query("key") String key);

    @GET("get")
    Call<RecipeModel> get(@Query("rId") String id,
                          @Query("key") String key);
}
