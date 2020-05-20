package com.bliepy.level_6_task_2.common

import com.bliepy.level_6_task_2.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object  ApiFactory {

    private val apiClient = OkHttpClient().newBuilder()
        .addInterceptor(ApiKeyInterceptor())
//        .addInterceptor(ApiMockInterceptor())
        .build()

    val webservice  by lazy {
         Retrofit.Builder()
            .client(apiClient)
            .baseUrl(BuildConfig.MOVIE_DB_API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(MovieDbService::class.java)
        }

        class ApiKeyInterceptor : Interceptor    {
            override fun intercept(chain: Interceptor.Chain): Response {
                val newUrl = chain.request().url
                    .newBuilder()
                    .addQueryParameter("api_key", BuildConfig.MOVIE_DB_API_KEY)
                    .build()
                val newRequest = chain.request()
                    .newBuilder()
                    .url(newUrl)
                    .build()
                return chain.proceed(newRequest)

            }
        }
    }
