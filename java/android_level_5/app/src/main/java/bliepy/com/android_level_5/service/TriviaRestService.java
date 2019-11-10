package bliepy.com.android_level_5.service;

import bliepy.com.android_level_5.model.TriviaModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TriviaRestService {
        @GET("/{month}/{dayOfMonth}/date?json")
        Call<TriviaModel> getTrivia(@Path("month") int monthNumber, @Path("dayOfMonth") int dayOfMonth);

        @GET("/random/trivia?json")
        Call<TriviaModel> getRandomTrivia();
}
