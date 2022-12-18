package com.example.yourweather.domain

class GetHourlyWeatherInfoUseCase(private val repository: WeatherRepository) {
     suspend operator fun invoke(
          longitude:Double,latitude:Double
     ) =repository.getHourlyWeather(longitude, latitude)
}