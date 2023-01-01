package com.example.yourweather.di

import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.domain.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindRepository(impl: WeatherRepositoryImpl):WeatherRepository
}