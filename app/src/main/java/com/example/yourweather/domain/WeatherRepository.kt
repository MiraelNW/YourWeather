package com.example.yourweather.domain

import androidx.lifecycle.LiveData
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.example.yourweather.domain.entity.HourlyWeatherInfo

interface WeatherRepository {

    fun getDailyWeatherByTheTime(time: String): DailyWeatherInfo

    fun getListDailyWeather(): LiveData<List<DailyWeatherInfo>>

    fun getHourlyWeatherByTheTime(time: String): HourlyWeatherInfo

    suspend fun loadData(longitude: Double, latitude: Double)
}