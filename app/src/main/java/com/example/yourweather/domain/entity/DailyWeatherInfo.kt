package com.example.yourweather.domain.entity

import java.text.SimpleDateFormat
import java.util.*

data class DailyWeatherInfo(
    var dailyTime: String,
    var sunrise: String? = null,
    var sunset: String? = null,
    var apparentTemperatureMax: Double? = null,
    var apparentTemperatureMin: Double? = null,
    var precipitation_sum: Double? = null,
    var weatherCode: Int? = null,
    var temperature_2m_max: Double? = null
) {

}