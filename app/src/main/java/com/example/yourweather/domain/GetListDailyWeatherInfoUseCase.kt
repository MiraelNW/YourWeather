package com.example.yourweather.domain

import javax.inject.Inject

class GetListDailyWeatherInfoUseCase @Inject constructor(private val repository: WeatherRepository) {
    operator fun invoke() = repository.getListDailyWeather()
}