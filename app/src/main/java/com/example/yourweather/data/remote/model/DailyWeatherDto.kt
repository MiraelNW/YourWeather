package com.example.yourweather.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyWeatherDto(
    @SerializedName("time")
    @Expose
    var time: List<String>,
    @SerializedName("sunrise")
    @Expose
    var sunrise: List<String>,
    @SerializedName("sunset")
    @Expose
    var sunset: List<String>,
    @SerializedName("apparent_temperature_max")
    @Expose
    var apparentTemperatureMax: List<Double>,
    @SerializedName("apparent_temperature_min")
    @Expose
    var apparentTemperatureMin: List<Double>,
    @SerializedName("precipitation_sum")
    @Expose
    var precipitation_sum: List<Double>,
    @SerializedName("weathercode")
    @Expose
    var weatherCode: List<Int>,
    @SerializedName("temperature_2m_max")
    @Expose
    var temperature_2m_max: List<Double>
)