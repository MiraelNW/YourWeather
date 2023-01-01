package com.example.yourweather.domain

import javax.inject.Inject

class GetDailyWeatherInfoUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(
        time: String
    ) = repository.getDailyWeatherByTheTime(time)
}