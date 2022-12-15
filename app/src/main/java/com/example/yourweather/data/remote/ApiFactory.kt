package com.example.yourweather.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_ULR = "https://api.open-meteo.com/v1/"
    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_ULR)
        .build()
    val apiService = retrofit.create(ApiService::class.java)
}