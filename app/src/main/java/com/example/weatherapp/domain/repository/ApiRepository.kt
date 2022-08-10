package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.entities.EntityCurrentWeather

interface ApiRepository {
    suspend fun getCurrentWeather(): EntityCurrentWeather
}