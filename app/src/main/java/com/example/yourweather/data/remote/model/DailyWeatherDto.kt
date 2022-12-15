package com.example.yourweather.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyWeatherDto(
    @SerializedName("time")
    @Expose
    var time: List<String>? = null,
    @SerializedName("sunrise")
    @Expose
    var sunrise: List<String>? = null,
    @SerializedName("sunset")
    @Expose
    var sunset: List<String>? = null,
    @SerializedName("apparent_temperature_max")
    @Expose
    var apparentTemperatureMax: List<Double>? = null,
    @SerializedName("apparent_temperature_min")
    @Expose
    var apparentTemperatureMin: List<Double>? = null
)