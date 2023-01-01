package com.example.yourweather.utils

import android.app.Application
import com.example.yourweather.di.DaggerApplicationComponent

class WeatherApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}