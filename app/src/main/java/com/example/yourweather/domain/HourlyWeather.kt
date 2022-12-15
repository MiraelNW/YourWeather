package com.example.yourweather.domain

data class HourlyWeather(

    var time: List<String>? = null,

    var apparentTemperature: List<Double>? = null,

    var snowfall: List<Double>? = null,

    var visibility: List<Double>? = null,

    var windSpeed10m: List<Double>? = null,

    var windDirection10m: List<Int>? = null,

    var shortwaveRadiation: List<Double>? = null
)