package com.example.weatherapp.model.repository

import com.example.weatherapp.model.data.CurrentWeather
import com.example.weatherapp.model.data.ForecastWeather
import com.example.weatherapp.model.data.ListForecast
import com.example.weatherapp.utils.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface ApiWeather {
    /*@GET("/data/$API_VERSION/weather?$LOCATION&appid=$API_KEY&units=$UNITS&lang=$LANG")
    fun getWeatherAsync(): Deferred<CurrentWeather>*/

    @GET("/data/$API_VERSION/weather?$LOCATION&appid=$API_KEY&units=$UNITS&lang=$LANG")
    suspend fun getCurrentWeather(): CurrentWeather

    @GET("/data/$API_VERSION/forecast?q=$CITY_LOCATION&appid=$API_KEY&units=$UNITS&lang=$LANG&cnt=$CNT")
    suspend fun getWeatherForecast(): List<ListForecast>

}