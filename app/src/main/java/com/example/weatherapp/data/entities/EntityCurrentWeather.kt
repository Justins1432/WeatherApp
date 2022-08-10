package com.example.weatherapp.data.entities

/**
 * Класс БД
 * Для хранения информации которая приходит с сети
 * В конструкторе указываем данные которые будем хранить
 */
data class EntityCurrentWeather(val temp: Double, val city: String)