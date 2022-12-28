package com.example.yourweather.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.domain.GetListDailyWeatherInfoUseCase
import com.example.yourweather.domain.LoadDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel(
    application: Application
) : AndroidViewModel(application) {

    val mapper = Mapper()
    val dao = AppDataBase.getInstance(application).weatherInfoDao()
    val repo = WeatherRepositoryImpl(dao, mapper)

    val scope = CoroutineScope(Dispatchers.IO)

    val weatherList = GetListDailyWeatherInfoUseCase(repo)
    val useCase2 = LoadDataUseCase(repo)

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

     fun startLoad(cityName: String) {
         scope.launch {
             val coroutine = launch(Dispatchers.Main) {
                 useCase2(cityName)
             }
             _loading.postValue(true)
             coroutine.join()
             _loading.postValue(false)
         }
     }

}