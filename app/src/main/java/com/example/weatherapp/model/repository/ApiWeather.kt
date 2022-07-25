package com.example.weatherapp.model.repository

import com.example.weatherapp.model.data.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET

interface ApiWeather {
    @GET("/data/2.5/weather?lat=53.21023449502424&lon=50.186252948855476&appid=a552b39b529b0402a3b40d2affee9ef4&units=metric&lang=ru")
    fun getWeather(): Call<List<CurrentWeather>>
}