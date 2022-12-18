package com.example.yourweather.domain

class GetDailyWeatherInfoUseCase(private val repository: WeatherRepository) {
     suspend operator fun invoke(
          longitude:Double,
          latitude:Double
     ) =repository.getDailyWeather(longitude,latitude)
}