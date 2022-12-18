package com.example.yourweather.domain

import androidx.lifecycle.LiveData

interface WeatherRepository {

    suspend fun getDailyWeather(longitude:Double,latitude:Double): LiveData<DailyWeatherInfo>

    suspend fun getHourlyWeather(longitude:Double,latitude:Double): LiveData<HourlyWeatherInfo>

    suspend fun loadData(longitude:Double,latitude:Double)
}