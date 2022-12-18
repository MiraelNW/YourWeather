package com.example.yourweather.domain

data class HourlyWeatherInfo(
    var hourlyTime: String,
    var apparentTemperature: Double? = null,
    var snowfall: Double? = null,
    var visibility: Double? = null,
    var windSpeed10m: Double? = null,
    var windDirection10m: Int? = null,
    var shortwaveRadiation: Double? = null,
    var relativehumidity_2m: Int? = null
)