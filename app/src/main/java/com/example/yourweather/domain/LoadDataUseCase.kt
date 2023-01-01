package com.example.yourweather.domain

import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(
        cityName:String
    ) = repository.loadCordsFromCityName(cityName)
}