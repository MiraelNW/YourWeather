package com.example.yourweather.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_ULR_FOR_GET_FORECAST = "https://api.open-meteo.com/"
    private const val BASE_ULR_FOR_GET_COORD = "https://geocoding-api.open-meteo.com/v1/"
    private val retrofitForecast = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_ULR_FOR_GET_FORECAST)
        .build()
    private val retrofitCoord = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_ULR_FOR_GET_COORD)
        .build()
    val apiServiceForecast = retrofitForecast.create(ApiService::class.java)
    val apiServiceCoord = retrofitCoord.create(ApiService::class.java)
}