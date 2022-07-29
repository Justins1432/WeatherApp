package com.example.weatherapp.model.repository

class WeatherRepository(private val apiHelper: ApiHelper) {
    suspend fun getWeather() = apiHelper.getWeather()
}