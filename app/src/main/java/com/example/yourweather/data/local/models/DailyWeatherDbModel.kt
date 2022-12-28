package com.example.yourweather.data.local.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.yourweather.data.local.Converters

@Entity(tableName = "DailyWeatherTable")
@TypeConverters(Converters::class)
data class DailyWeatherDbModel(
    @PrimaryKey
    var dailyTime: String,
    var sunrise: String,
    var sunset: String,
    var apparentTemperatureMax: Double,
    var apparentTemperatureMin: Double,
    var precipitation_sum: Double,
    var weatherCode: Int,
    var temperature_2m_max: Double
)