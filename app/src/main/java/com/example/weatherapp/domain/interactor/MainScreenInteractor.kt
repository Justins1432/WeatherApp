package com.example.weatherapp.domain.interactor

import com.example.weatherapp.data.network.networkModel.CurrentWeather
import com.example.weatherapp.data.repository.ApiRepositoryImpl
import com.example.weatherapp.data.repository.DatabaseRepositoryImpl
import com.example.weatherapp.domain.repository.ApiRepository
import com.example.weatherapp.domain.repository.DatabaseRepository

class MainScreenInteractor {
    private val apiRepository: ApiRepository = ApiRepositoryImpl()
    private val databaseRepository: DatabaseRepository = DatabaseRepositoryImpl()

    suspend fun getCurrentWeather() {
        apiRepository.getCurrentWeather()
    }

}