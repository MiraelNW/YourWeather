package com.example.yourweather.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfCitiesDto(
    @SerializedName("results")
    @Expose
    val cityCoordDto: List<CityCoordDto>? = null
)