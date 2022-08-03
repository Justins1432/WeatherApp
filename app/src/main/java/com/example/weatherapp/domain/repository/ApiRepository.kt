package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.network.networkModel.CurrentWeather

interface ApiRepository {
    suspend fun getCurrentWeather(): CurrentWeather
}