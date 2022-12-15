package com.example.yourweather.domain


class DailyWeather(

    var time: List<String>? = null,


    var sunrise: List<String>? = null,


    var sunset: List<String>? = null,

    var apparentTemperatureMax: List<Double>? = null,


    var apparentTemperatureMin: List<Double>? = null
)