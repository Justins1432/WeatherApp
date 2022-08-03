package com.example.weatherapp.data.repository

import com.example.weatherapp.app.MyApplication
import com.example.weatherapp.domain.repository.ApiRepository
import com.example.weatherapp.data.network.networkModel.CurrentWeather

class ApiRepositoryImpl: ApiRepository {
    private val api = MyApplication.apiWeather

    override suspend fun getCurrentWeather(): CurrentWeather {
        return api.getCurrentWeatherAsync().await()
    }

}