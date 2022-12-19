package com.example.yourweather.domain

class GetHourlyWeatherInfoUseCase(private val repository: WeatherRepository) {
      operator fun invoke(
         time:String
     ) =repository.getHourlyWeatherByTheTime(time)
}