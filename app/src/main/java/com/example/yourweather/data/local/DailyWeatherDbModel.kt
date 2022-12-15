package com.example.yourweather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DailyWeatherTable")
data class DailyWeatherDbModel(
    @PrimaryKey
    var time: List<String>? = null,
    var sunrise: List<String>? = null,
    var sunset: List<String>? = null,
    var apparentTemperatureMax: List<Double>? = null,
    var apparentTemperatureMin: List<Double>? = null,
)