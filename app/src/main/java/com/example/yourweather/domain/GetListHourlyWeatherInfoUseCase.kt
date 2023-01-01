package com.example.yourweather.domain

import com.example.yourweather.domain.WeatherRepository
import javax.inject.Inject

class GetListHourlyWeatherInfoUseCase @Inject constructor(private val repository: WeatherRepository) {
    operator fun invoke(dateFrom: String, dateTo: String) =
        repository.getListHourlyWeather(dateFrom, dateTo)
}