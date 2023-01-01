package com.example.yourweather.presentation.weatherDetailPackage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.domain.GetDailyWeatherInfoUseCase
import com.example.yourweather.domain.GetHourlyWeatherInfoUseCase
import com.example.yourweather.domain.GetListHourlyWeatherInfoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class WeatherDetailInfoViewModel @Inject constructor(
     val hourlyWeather: GetHourlyWeatherInfoUseCase,
     val dailyWeather : GetDailyWeatherInfoUseCase,
     val listOfHourlyWeather: GetListHourlyWeatherInfoUseCase,
) : ViewModel() {


}