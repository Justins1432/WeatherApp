package com.example.weatherapp.model.weather

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h") val oneHour: Int?,
    @SerializedName("3h") val threeHour: Int?
)
