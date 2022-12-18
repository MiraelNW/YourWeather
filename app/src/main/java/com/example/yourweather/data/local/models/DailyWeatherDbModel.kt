package com.example.yourweather.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.yourweather.data.local.Converters

@Entity(tableName = "DailyWeatherTable")
@TypeConverters(Converters::class)
data class DailyWeatherDbModel(
    @PrimaryKey
    var dailyTime:String,
    var sunrise:String? = null,
    var sunset:String? = null,
    var apparentTemperatureMax:Double? = null,
    var apparentTemperatureMin:Double? = null,
)