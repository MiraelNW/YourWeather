package com.example.yourweather.data.remote.model.coords

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityCoordDto(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("latitude")
    @Expose
    var latitude: Double,
    @SerializedName("longitude")
    @Expose
    var longitude: Double
)