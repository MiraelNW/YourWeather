package com.example.yourweather.domain

import com.example.yourweather.domain.WeatherRepository

class GetListHourlyWeatherInfoUseCase(private val repository: WeatherRepository) {
    operator fun invoke(dateFrom: String, dateTo: String) =
        repository.getListHourlyWeather(dateFrom, dateTo)
}