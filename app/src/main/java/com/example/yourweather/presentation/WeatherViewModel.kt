package com.example.yourweather.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.local.WeatherInfoDao
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.domain.GetListDailyWeatherInfoUseCase
import com.example.yourweather.domain.LoadDataUseCase
import com.example.yourweather.domain.WeatherRepository
import com.example.yourweather.presentation.WeatherAdapter.WeatherAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(
      application: Application
) : AndroidViewModel(application) {

    val mapper = Mapper()
    val dao = AppDataBase.getInstance(application).weatherInfoDao()
    val scope = CoroutineScope(Dispatchers.IO)

    val repo = WeatherRepositoryImpl(dao, mapper)
    val weatherList = GetListDailyWeatherInfoUseCase(repo)
    val useCase2 = LoadDataUseCase(repo)

    init {
        scope.launch {
            useCase2(55.0, 65.0)
        }
    }

}