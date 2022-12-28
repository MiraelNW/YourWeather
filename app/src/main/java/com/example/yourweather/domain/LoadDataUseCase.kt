package com.example.yourweather.domain

class LoadDataUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke(
        cityName:String
    ) = repository.loadCordsFromCityName(cityName)
}