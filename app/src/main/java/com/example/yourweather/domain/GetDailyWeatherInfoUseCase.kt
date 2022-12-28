package com.example.yourweather.domain

class GetDailyWeatherInfoUseCase(private val repository: WeatherRepository) {
      suspend operator fun invoke(
          time:String
     ) =repository.getDailyWeatherByTheTime(time)
}