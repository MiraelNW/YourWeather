package com.example.yourweather.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.yourweather.databinding.ActivityWeatherBinding

class WeatherActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityWeatherBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("WeatherActivity","create")
    }

    companion object{

        fun newIntent(context: Context)= Intent(context, WeatherActivity::class.java)

    }
}