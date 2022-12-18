package com.example.yourweather.data.repositoryImpl

import androidx.lifecycle.LiveData
import com.example.yourweather.data.local.WeatherInfoDao
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.remote.ApiFactory
import com.example.yourweather.domain.DailyWeatherInfo
import com.example.yourweather.domain.HourlyWeatherInfo
import com.example.yourweather.domain.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherInfoDao: WeatherInfoDao,
    private val mapper: Mapper,
) : WeatherRepository {
    override suspend fun getDailyWeather(longitude:Double,latitude:Double): LiveData<DailyWeatherInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getHourlyWeather(longitude:Double,latitude:Double): LiveData<HourlyWeatherInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun loadData(longitude: Double, latitude: Double) {
        val weather = ApiFactory.apiServiceForecast.getForecastByGeoCords(55.0,65.0)
        for (hour in 1..167) {
            weatherInfoDao.insertHourlyWeatherInfo(
                mapper.mapHourlyWeatherDtoToHourlyWeatherDbModel(
                    weather.hourly,
                    hour
                )
            )
        }
        for (day in 1..6) {
            weatherInfoDao.insertDailyWeatherInfo(
                mapper.mapDailyWeatherDtoToDailyWeatherDbModel(
                    weather.daily,
                    day
                )
            )
        }
    }
}