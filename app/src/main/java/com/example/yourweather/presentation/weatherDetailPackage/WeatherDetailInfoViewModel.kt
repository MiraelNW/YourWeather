package com.example.yourweather.presentation.weatherDetailPackage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.domain.GetDailyWeatherInfoUseCase
import com.example.yourweather.domain.GetHourlyWeatherInfoUseCase
import com.example.yourweather.domain.GetListHourlyWeatherInfoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class WeatherDetailInfoViewModel(application: Application) : AndroidViewModel(application) {

    val mapper = Mapper()
    val dao = AppDataBase.getInstance(application).weatherInfoDao()
    val repo = WeatherRepositoryImpl(dao, mapper)

    val hourlyWeather = GetHourlyWeatherInfoUseCase(repo)

    val listOfHourlyWeather = GetListHourlyWeatherInfoUseCase(repo)

    val dailyWeather = GetDailyWeatherInfoUseCase(repo)
}