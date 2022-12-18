package com.example.yourweather.presentation.WeatherAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.yourweather.databinding.DailyWeatherItemBinding
import com.example.yourweather.domain.HourlyWeatherInfo

class WeatherAdapter : ListAdapter<HourlyWeatherInfo, WeatherViewHolder>(WeatherInfoDiffCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = DailyWeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
        false
        )
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherInfo =getItem(position)


    }
}