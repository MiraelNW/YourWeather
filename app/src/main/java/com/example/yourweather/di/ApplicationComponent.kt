package com.example.yourweather.di

import android.app.Application
import com.example.yourweather.utils.WeatherApp
import com.example.yourweather.presentation.MainActivity
import com.example.yourweather.presentation.searchPackage.SearchFragment
import com.example.yourweather.presentation.splashPackage.SplashFragment
import com.example.yourweather.presentation.splashPackage.WeatherActivity
import com.example.yourweather.presentation.weatherDetailPackage.WeatherDetailInfoFragment
import com.example.yourweather.presentation.weatherPackage.WeatherFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class,DataModule::class,ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: WeatherActivity)
    fun inject(fragment: SplashFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: WeatherDetailInfoFragment)
    fun inject(fragment: WeatherFragment)
    fun inject(app: WeatherApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }


}