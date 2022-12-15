package com.example.yourweather.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HourlyWeatherDto(
    @SerializedName("time")
    @Expose
    var time: List<String>,
    @SerializedName("apparent_temperature")
    @Expose
    var apparentTemperature: List<Double>? = null,
    @SerializedName("snowfall")
    @Expose
    var snowfall: List<Double>? = null,
    @SerializedName("visibility")
    @Expose
    var visibility: List<Double>? = null,
    @SerializedName("windspeed_10m")
    @Expose
    var windSpeed10m: List<Double>? = null,
    @SerializedName("winddirection_10m")
    @Expose
    var windDirection10m: List<Int>? = null,
    @SerializedName("shortwave_radiation")
    @Expose
    var shortwaveRadiation: List<Double>? = null
)