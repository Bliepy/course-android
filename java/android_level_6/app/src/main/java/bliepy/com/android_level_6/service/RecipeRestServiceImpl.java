package bliepy.com.android_level_6.service;

import bliepy.com.android_level_6.model.RecipeModel;
import bliepy.com.android_level_6.model.RecipeSearchResultModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeRestServiceImpl {

    private static String BASE_API_URL = "https://www.food2fork.com/api/";
    private static String BASE_API_KEY = "eb1f92dbb9d10e8c2ffee87128503187";
    private Retrofit retrofit;

    private RecipeRestService getRecipeService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RecipeRestService.class);
    }

    public Call<RecipeSearchResultModel> callSearchRecipe(String search) {
        return getRecipeService().search(search, BASE_API_KEY);
    }

    public Call<RecipeModel> callRecipe(String id) {
        return getRecipeService().get(id, BASE_API_KEY);
    }
}
