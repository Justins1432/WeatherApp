package com.example.weatherapp.model.repository

class ApiHelper(private val apiWeather: ApiWeather) {
    suspend fun getWeather() = apiWeather.getCurrentWeather()
}