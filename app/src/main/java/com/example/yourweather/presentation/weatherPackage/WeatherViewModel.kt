package com.example.yourweather.presentation.weatherPackage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.domain.GetDailyWeatherInfoUseCase
import com.example.yourweather.domain.GetHourlyWeatherInfoUseCase
import com.example.yourweather.domain.GetListDailyWeatherInfoUseCase
import com.example.yourweather.domain.LoadDataUseCase
import com.example.yourweather.domain.entity.DailyWeatherInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.time.ZonedDateTime

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val scope = CoroutineScope(Dispatchers.IO)

    val mapper = Mapper()
    val dao = AppDataBase.getInstance(application).weatherInfoDao()
    val repo = WeatherRepositoryImpl(dao, mapper)

    val weatherList = GetListDailyWeatherInfoUseCase(repo)

    val hourlyWeather = GetHourlyWeatherInfoUseCase(repo)

    val dailyWeather = GetDailyWeatherInfoUseCase(repo)

}

