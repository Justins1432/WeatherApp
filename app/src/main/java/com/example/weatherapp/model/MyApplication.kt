package com.example.weatherapp.model

import android.app.Application
import com.example.weatherapp.model.repository.ApiWeather
import com.example.weatherapp.model.repository.NetworkService

class MyApplication : Application() {

    companion object {
        lateinit var apiWeather: ApiWeather
    }

    override fun onCreate() {
        super.onCreate()

        val networkService = NetworkService()
        apiWeather = networkService.apiWeather
    }
}