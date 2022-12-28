package com.example.yourweather.domain.entity

data class HourlyWeatherInfo(
    var hourlyTime: String,
    var apparentTemperature: Double,
    var snowfall: Double,
    var visibility: Double,
    var windSpeed10m: Double,
    var windDirection10m: Int,
    var shortwaveRadiation: Double,
    var relativehumidity_2m: Int,
    var temperature_2m: Double,

)