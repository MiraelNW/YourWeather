package com.example.yourweather.presentation.searchPackage

import android.app.Application
import android.app.ProgressDialog
import android.util.Log
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
    private val loadData: LoadDataUseCase
) : ViewModel() {

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private var _apiError = MutableLiveData<Boolean>()
    val apiError: LiveData<Boolean> get() = _apiError

    private var _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _error

    fun startLoad(cityName: String) {
        _loading.value = true
        viewModelScope.launch {
            val coroutine = launch(Dispatchers.Main) {
                _apiError.value = false
                try {
                    loadData(cityName)
                } catch (e: Exception) {
                    _loading.value = false
                    _apiError.value = true
                }
            }
            coroutine.join()
            _loading.value = false
        }
    }

    fun validateCityName(cityName: String): Boolean {
        if (cityName.isEmpty() || cityName.any { it.isDigit() }) {
            _error.value = true
            return false
        }else{
            return true
        }
    }

    fun resetError(){
        _error.value = false
    }

}