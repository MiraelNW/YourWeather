package com.example.yourweather.presentation.weatherPackage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yourweather.R
import com.example.yourweather.databinding.ActivityWeatherBinding

class WeatherActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityWeatherBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val cityName = intent.getStringExtra(WeatherFragment.CITY_NAME)  ?: ""
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_weather_container, WeatherFragment.newInstance(cityName))
            .commit()

    }

    companion object{
        private const val CITY_NAME = "cityName"
        fun newIntent(context: Context, cityName : String):Intent{
            val intent = Intent(context, WeatherActivity::class.java)
            intent.putExtra(CITY_NAME,cityName)
            return intent
        }
    }
}