package com.example.yourweather.presentation.searchPackage

import android.app.Application
import androidx.lifecycle.*
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.domain.GetListDailyWeatherInfoUseCase
import com.example.yourweather.domain.LoadDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val loadData : LoadDataUseCase
) : ViewModel() {

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private var _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _error

    fun startLoad(cityName: String) {
        viewModelScope.launch {
            val coroutine = launch(Dispatchers.Main) {
                _error.value = false
                _loading.value = true
                try {
                    loadData(cityName)
                } catch (e: Exception) {
                    _error.value = true
                }
                _loading.value = false
            }
            coroutine.join()
        }
    }

}