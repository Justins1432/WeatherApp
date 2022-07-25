package com.example.weatherapp.model.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    private var mInstance: NetworkService? = null
    private val URL: String = "https://api.openweathermap.org"
    private var retrofit: Retrofit? = null

    private fun netService() {
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance(): NetworkService? {
        if (mInstance == null) {
            mInstance = NetworkService()
        }
        return mInstance
    }

    fun getWeatherApi(): ApiWeather? {
        return retrofit?.create(ApiWeather::class.java)
    }

}