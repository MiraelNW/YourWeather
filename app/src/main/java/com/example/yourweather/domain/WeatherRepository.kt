package com.example.yourweather.domain

import androidx.lifecycle.LiveData
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.example.yourweather.domain.entity.HourlyWeatherInfo

interface WeatherRepository {

    fun getDailyWeatherByTheTime(time: String): LiveData<DailyWeatherInfo>

    fun getListDailyWeather(): LiveData<List<DailyWeatherInfo>>

    suspend fun getHourlyWeatherByTheTime(time: String): LiveData<HourlyWeatherInfo>

    suspend fun loadCordsFromCityName(cityName:String)
}