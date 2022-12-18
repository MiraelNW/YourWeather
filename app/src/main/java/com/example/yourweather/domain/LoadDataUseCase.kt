package com.example.yourweather.domain

class LoadDataUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke(
        latitude:Double,longitude:Double
    ) = repository.loadData(latitude,longitude)
}