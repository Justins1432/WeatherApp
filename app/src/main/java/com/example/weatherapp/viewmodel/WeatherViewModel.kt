package com.example.weatherapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.weatherapp.model.repository.Resource
import com.example.weatherapp.model.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers


class WeatherViewModel(private val weatherRepository: WeatherRepository): ViewModel() {
    fun getWeather() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = weatherRepository.getWeather()))
        }catch (exception: Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Ошибка загрузки данных!"))
        }
    }
}