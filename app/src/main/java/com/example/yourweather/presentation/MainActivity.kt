package com.example.yourweather.presentation

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.yourweather.R
import com.example.yourweather.data.local.AppDataBase
import com.example.yourweather.data.local.WeatherInfoDao
import com.example.yourweather.data.mapper.Mapper
import com.example.yourweather.data.remote.ApiFactory
import com.example.yourweather.data.repositoryImpl.WeatherRepositoryImpl
import com.example.yourweather.databinding.ActivityMainBinding
import com.example.yourweather.domain.GetDailyWeatherInfoUseCase
import com.example.yourweather.domain.GetHourlyWeatherInfoUseCase
import com.example.yourweather.domain.LoadDataUseCase
import com.mikhaellopez.rxanimation.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_splash_search,SplashFragment.newInstance())
            .commit()

    }
}

