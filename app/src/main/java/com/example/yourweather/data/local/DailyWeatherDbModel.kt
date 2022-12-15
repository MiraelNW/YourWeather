package com.example.yourweather.data.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import org.jetbrains.annotations.NonNls

@Entity(tableName = "DailyWeatherTable")
@TypeConverters(Converters::class)
data class DailyWeatherDbModel(
    @PrimaryKey
    var time: List<String>,
    var sunrise: List<String>? = null,
    var sunset: List<String>? = null,
    var apparentTemperatureMax: List<Double>? = null,
    var apparentTemperatureMin: List<Double>? = null,
)