package com.example.weatherapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.network.networkModel.CurrentWeather
import com.example.weatherapp.domain.interactor.MainScreenInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val interactor = MainScreenInteractor()

    fun getCurrentWeather(): CurrentWeather {
        val currentWeather: CurrentWeather
        return viewModelScope.launch(Dispatchers.IO) { continuation ->
            //continuation
        }
    }

    /*fun getWeather() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = weatherRepository.getWeather()))
        }catch (exception: Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Ошибка загрузки данных!"))
        }
    }*/

}