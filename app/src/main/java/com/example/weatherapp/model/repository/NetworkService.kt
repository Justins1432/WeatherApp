package com.example.weatherapp.model.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkService {
    private val URL: String = "https://api.openweathermap.org"
    //var apiWeather: ApiWeather

    private val httpLoggingInterceptor = HttpLoggingInterceptor()

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    init {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        //apiWeather = retrofit.create(ApiWeather::class.java)
    }
    val apiWeather: ApiWeather = retrofit.create(ApiWeather::class.java)
}