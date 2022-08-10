package com.example.weatherapp.data.repository

import com.example.weatherapp.app.MyApplication
import com.example.weatherapp.data.entities.EntityCurrentWeather
import com.example.weatherapp.domain.repository.ApiRepository
import com.example.weatherapp.data.network.networkModel.CurrentWeather

class ApiRepositoryImpl: ApiRepository {
    private val api = MyApplication.apiWeather

    override suspend fun getCurrentWeather(): EntityCurrentWeather {
        val currentWeather: CurrentWeather = api.getCurrentWeatherAsync()
        return EntityCurrentWeather(temp = currentWeather.main?.temp!!, city = currentWeather.name.toString())
        //return api.getCurrentWeatherAsync().await()
    }

}