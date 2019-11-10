package bliepy.com.android_level_5.service;

import android.content.Context;

import java.util.Calendar;

import retrofit2.Call;
import bliepy.com.android_level_5.model.TriviaModel;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TriviaRestServiceImpl {

    private static String BASE_API_URL = "http://numbersapi.com/";
    private Retrofit retrofit;

    private TriviaRestService getTriviaService(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(TriviaRestService.class);
    }

    public Call<TriviaModel> callTriviaService(Context context) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return getTriviaService().getRandomTrivia();
    }
}
