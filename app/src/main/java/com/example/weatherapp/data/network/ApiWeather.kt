package com.example.weatherapp.data.network

import com.example.weatherapp.data.network.networkModel.CurrentWeather
import com.example.weatherapp.model.data.ForecastWeather
import com.example.weatherapp.utils.*
import retrofit2.http.GET
import kotlinx.coroutines.Deferred

interface ApiWeather {
    @GET("/data/$API_VERSION/weather?$LOCATION&appid=$API_KEY&units=$UNITS&lang=$LANG")
    suspend fun getCurrentWeatherAsync(): Deferred<CurrentWeather>

    @GET("/data/$API_VERSION/forecast?q=$CITY_LOCATION&appid=$API_KEY&units=$UNITS&lang=$LANG&cnt=$CNT")
    suspend fun getForecastWeather(): Deferred<ForecastWeather>

}