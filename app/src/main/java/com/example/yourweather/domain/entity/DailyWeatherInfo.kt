package com.example.yourweather.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.util.*

@Parcelize
data class DailyWeatherInfo(
    var dayOfWeek: String,
    var dailyTime: String,
    var sunrise: String? = null,
    var sunset: String? = null,
    var apparentTemperatureMax: Double? = null,
    var apparentTemperatureMin: Double? = null,
    var precipitation_sum: Double? = null,
    var weatherCode: Int? = null,
    var temperature_2m_max: Double? = null
) :Parcelable