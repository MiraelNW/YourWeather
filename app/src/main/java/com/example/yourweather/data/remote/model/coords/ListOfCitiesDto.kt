package com.example.yourweather.data.remote.model.coords

import com.example.yourweather.data.remote.model.coords.CityCoordDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfCitiesDto(
    @SerializedName("results")
    @Expose
    val cityCoordDto: List<CityCoordDto>
)