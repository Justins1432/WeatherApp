package com.example.weatherapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.entities.EntityCurrentWeather
import com.example.weatherapp.data.network.Resource
import com.example.weatherapp.data.network.networkModel.CurrentWeather
import com.example.weatherapp.domain.interactor.MainScreenInteractor
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val interactor = MainScreenInteractor()
    //private lateinit var currentWeather: CurrentWeather


    fun getCurrentWeather() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = interactor.getCurrentWeather()))
        } catch (exception: Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Ошибка загрузки данных"))
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