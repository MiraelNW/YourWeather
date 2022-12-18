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
    var apparentTemperature: Double? = null,
    var snowfall: Double? = null,
    var visibility: Double? = null,
    var windSpeed10m: Double? = null,
    var windDirection10m: Int? = null,
    var shortwaveRadiation: Double? = null,
    var relativehumidity_2m: Int? = null
)