package com.example.yourweather.domain.entity

data class DailyWeatherInfo (
    var dailyTime: String,
    var sunrise: String,
    var sunset: String,
    var apparentTemperatureMax: Double,
    var apparentTemperatureMin: Double,
    var precipitation_sum: Double,
        )