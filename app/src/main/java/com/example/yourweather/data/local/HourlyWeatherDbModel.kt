package com.example.yourweather.data.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Entity(tableName = "HourlyWeatherTable")
@TypeConverters(Converters::class)
data class HourlyWeatherDbModel(
    @PrimaryKey
    var time: List<String>,
    var apparentTemperature: List<Double>? = null,
    var snowfall: List<Double>? = null,
    var visibility: List<Double>? = null,
    var windSpeed10m: List<Double>? = null,
    var windDirection10m: List<Int>? = null,
    var shortwaveRadiation: List<Double>? = null
)