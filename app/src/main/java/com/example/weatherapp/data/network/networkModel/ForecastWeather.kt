package com.example.weatherapp.model.data

import com.example.weatherapp.data.network.networkModel.*
import com.google.gson.annotations.SerializedName

class ForecastWeather(
    @SerializedName("cod") val cod: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("cnt") val cnt: Int?,
    @SerializedName("list") val listForecast: List<ListForecast>?,
    @SerializedName("city") val city: City?
)

data class ListForecast(
    @SerializedName("dt") val dt: Int?,
    @SerializedName("main") val main: Main?,
    @SerializedName("weather") val weather: List<Weather>?,
    @SerializedName("clouds") val clouds: Clouds?,
    @SerializedName("wind") val wind: Wind?,
    @SerializedName("visibility") val visibility: Int?,
    @SerializedName("pop") val pop: Double?,
    @SerializedName("sys") val sys: Sys?,
    @SerializedName("dt_txt") val dtTxt: String?
)

data class City(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("coord") val coord: Coord?,
    @SerializedName("country") val country: String?,
    @SerializedName("population") val population: Int?,
    @SerializedName("timezone") val timezone: Int?,
    @SerializedName("sunrise") val sunrise: Int?,
    @SerializedName("sunset") val sunset: Int?
)