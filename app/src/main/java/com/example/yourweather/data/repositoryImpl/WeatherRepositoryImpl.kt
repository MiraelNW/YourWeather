package com.example.yourweather.data.repositoryImpl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.yourweather.data.local.WeatherInfoDao
import com.example.yourweather.data.local.models.DailyWeatherDbModel
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.remote.ApiFactory
import com.example.yourweather.data.remote.model.coords.ListOfCitiesDto
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.example.yourweather.domain.entity.HourlyWeatherInfo
import com.example.yourweather.domain.WeatherRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherInfoDao: WeatherInfoDao,
    private val mapper: Mapper,
) : WeatherRepository {

    override fun getDailyWeatherByTheTime(time: String): LiveData<DailyWeatherInfo> {
        return Transformations.map(weatherInfoDao.getDailyWeatherByTime(time)) {
            mapper.mapDailyWeatherDbToDailyWeatherInfo(it)
        }
    }

    override fun getListDailyWeather(): LiveData<List<DailyWeatherInfo>> {
        return Transformations.map(weatherInfoDao.getListDailyWeatherByTime()) {
            it.map {
                mapper.mapDailyWeatherDbToDailyWeatherInfo(it)
            }
        }
    }

    override fun getListHourlyWeather(dateFrom :String,dateTo:String): LiveData<List<HourlyWeatherInfo>> {
        return Transformations.map(weatherInfoDao.getListHourlyWeatherByTime(dateFrom, dateTo)) {
            it.map {
                mapper.mapHourlyWeatherDbToHourlyWeatherInfo(it)
            }
        }
    }

    override  fun getHourlyWeatherByTheTime(time: String): LiveData<HourlyWeatherInfo> {
        return Transformations.map(weatherInfoDao.getHourlyWeatherByTime(time)) {
            mapper.mapHourlyWeatherDbToHourlyWeatherInfo(it)
        }

    }


    override suspend fun loadCordsFromCityName(cityName: String) {
        val listOfCities = ApiFactory.apiServiceCoord.getCoordByCityName(cityName)

        val weather = ApiFactory.apiServiceForecast.getForecastByGeoCords(
            listOfCities.cityCoordDto[0].latitude, listOfCities.cityCoordDto[0].longitude
        )
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
