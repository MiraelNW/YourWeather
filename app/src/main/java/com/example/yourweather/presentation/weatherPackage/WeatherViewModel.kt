package com.example.yourweather.presentation.weatherPackage

import androidx.lifecycle.ViewModel
import com.example.yourweather.domain.GetHourlyWeatherInfoUseCase
import com.example.yourweather.domain.GetListDailyWeatherInfoUseCase
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    val weatherList : GetListDailyWeatherInfoUseCase,
    val hourlyWeather : GetHourlyWeatherInfoUseCase
) : ViewModel() {

}

