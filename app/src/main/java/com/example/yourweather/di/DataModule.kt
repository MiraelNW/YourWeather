package com.example.yourweather.di

import android.app.Application
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.local.WeatherInfoDao
import com.example.yourweather.data.remote.ApiFactory
import com.example.yourweather.data.remote.ApiService
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    companion object{

        @Provides
        fun provideWeatherInfoDao(application: Application):WeatherInfoDao{
          return  AppDataBase.getInstance(application).weatherInfoDao()
        }

        @Provides
        fun provideApiServiceCoord():ApiService{
            return ApiFactory.apiServiceCoord
        }

        @Provides
        fun provideApiServiceForecast():ApiService{
            return ApiFactory.apiServiceForecast
        }
    }
}