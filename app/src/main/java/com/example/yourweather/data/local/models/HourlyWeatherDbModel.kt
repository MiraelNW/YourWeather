package com.example.yourweather.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.yourweather.data.local.Converters

@Entity(tableName = "HourlyWeatherTable")
@TypeConverters(Converters::class)
data class HourlyWeatherDbModel(
    @PrimaryKey
    var hourlyTime: String,
    var apparentTemperature: Double,
    var snowfall: Double,
    var visibility: Double,
    var windSpeed10m: Double,
    var windDirection10m: Int,
    var shortwaveRadiation: Double,
    var relativehumidity_2m: Int
)