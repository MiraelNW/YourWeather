package com.example.yourweather.domain

import javax.inject.Inject

class GetHourlyWeatherInfoUseCase @Inject constructor(private val repository: WeatherRepository) {
    operator fun invoke(
        time: String
    ) = repository.getHourlyWeatherByTheTime(time)
}