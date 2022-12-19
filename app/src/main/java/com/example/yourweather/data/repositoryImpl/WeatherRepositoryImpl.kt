package com.example.yourweather.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.yourweather.data.local.WeatherInfoDao
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.remote.ApiFactory
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.example.yourweather.domain.entity.HourlyWeatherInfo
import com.example.yourweather.domain.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherInfoDao: WeatherInfoDao,
    private val mapper: Mapper,
) : WeatherRepository {

    override fun getDailyWeatherByTheTime(time: String): DailyWeatherInfo {

        return mapper.mapDailyWeatherDbToDailyWeatherInfo(weatherInfoDao.getDailyWeatherByTime(time))
    }

    override fun getListDailyWeather(): LiveData<List<DailyWeatherInfo>> {
        return Transformations.map( weatherInfoDao.getListDailyWeatherByTime()){
            it.map {
                mapper.mapDailyWeatherDbToDailyWeatherInfo(it)
            }
        }
    }

    override fun getHourlyWeatherByTheTime(time: String): HourlyWeatherInfo {
        return mapper.mapHourlyWeatherDbToHourlyWeatherInfo(
            weatherInfoDao.getHourlyWeatherByTime(
                time
            )
        )

    }

    override suspend fun loadData(longitude: Double, latitude: Double) {
        val weather = ApiFactory.apiServiceForecast.getForecastByGeoCords(55.0, 65.0)
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