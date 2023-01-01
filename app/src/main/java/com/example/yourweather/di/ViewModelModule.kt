package com.example.yourweather.di

import androidx.lifecycle.ViewModel
import com.example.yourweather.presentation.searchPackage.SearchViewModel
import com.example.yourweather.presentation.weatherDetailPackage.WeatherDetailInfoViewModel
import com.example.yourweather.presentation.weatherPackage.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

@Binds
@IntoMap
@ViewModelKey(SearchViewModel::class)
fun bindSearchViewModel(impl:SearchViewModel):ViewModel

@Binds
@IntoMap
@ViewModelKey(WeatherDetailInfoViewModel::class)
fun bindWeatherDetailInfoViewModel(impl:WeatherDetailInfoViewModel):ViewModel

@Binds
@IntoMap
@ViewModelKey(WeatherViewModel::class)
fun bindWeatherViewModel(impl:WeatherViewModel):ViewModel
}