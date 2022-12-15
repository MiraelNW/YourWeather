package com.example.yourweather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HourlyWeatherTable")
data class HourlyWeatherDbModel(
    @PrimaryKey
    var time: List<String>? = null,
    var apparentTemperature: List<Double>? = null,
    var snowfall: List<Double>? = null,
    var visibility: List<Double>? = null,
    var windSpeed10m: List<Double>? = null,
    var windDirection10m: List<Int>? = null,
    var shortwaveRadiation: List<Double>? = null
)