package com.example.yourweather.domain

class GetListDailyWeatherInfoUseCase(private val repository: WeatherRepository) {
    operator fun invoke() = repository.getListDailyWeather()
}