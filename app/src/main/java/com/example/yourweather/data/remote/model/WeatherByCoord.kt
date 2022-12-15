package com.example.yourweather.data.remote.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class WeatherByCoord(
    var city: String? = null,
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null,
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null,
    @SerializedName("timezone")
    @Expose
    var timezone: String? = null,

    @SerializedName("hourly")
    @Expose
    var hourly: HourlyWeatherDto,

    @SerializedName("daily")
    @Expose
    var daily: DailyWeatherDto
)