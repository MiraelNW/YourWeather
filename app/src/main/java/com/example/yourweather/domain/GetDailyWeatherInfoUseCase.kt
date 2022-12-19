package com.example.yourweather.domain

class GetDailyWeatherInfoUseCase(private val repository: WeatherRepository) {
     operator fun invoke(
          time:String
     ) =repository.getDailyWeatherByTheTime(time)
}