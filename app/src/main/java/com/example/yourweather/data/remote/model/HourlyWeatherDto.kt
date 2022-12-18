package com.example.yourweather.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HourlyWeatherDto(
    @SerializedName("time")
    @Expose
    var time: List<String>,
    @SerializedName("apparent_temperature")
    @Expose
    var apparentTemperature: List<Double>,
    @SerializedName("snowfall")
    @Expose
    var snowfall: List<Double>,
    @SerializedName("visibility")
    @Expose
    var visibility: List<Double>,
    @SerializedName("windspeed_10m")
    @Expose
    var windSpeed10m: List<Double>,
    @SerializedName("winddirection_10m")
    @Expose
    var windDirection10m: List<Int>,
    @SerializedName("shortwave_radiation")
    @Expose
    var shortwaveRadiation: List<Double>,
    @SerializedName("relativehumidity_2m")
    @Expose
    var relativehumidity_2m: List<Int>
)