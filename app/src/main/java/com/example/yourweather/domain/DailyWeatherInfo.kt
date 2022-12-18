package com.example.yourweather.domain

data class DailyWeatherInfo (
    var dailyTime:String,
    var sunrise:String? = null,
    var sunset:String? = null,
    var apparentTemperatureMax:Double? = null,
    var apparentTemperatureMin:Double? = null,
        )