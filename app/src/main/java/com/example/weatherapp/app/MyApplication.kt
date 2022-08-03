package com.example.weatherapp.app

import android.app.Application
import com.example.weatherapp.data.network.ApiWeather
import com.example.weatherapp.data.network.NetworkService

/**
 * Класс инициализации сети
 */
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