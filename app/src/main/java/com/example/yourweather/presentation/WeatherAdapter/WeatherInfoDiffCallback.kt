package com.example.yourweather.presentation.WeatherAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.yourweather.data.remote.model.DailyWeatherDto
import com.example.yourweather.domain.DailyWeatherInfo
import com.example.yourweather.domain.HourlyWeatherInfo

class WeatherInfoDiffCallback : DiffUtil.ItemCallback<HourlyWeatherInfo>(){
    override fun areItemsTheSame(oldItem: HourlyWeatherInfo, newItem: HourlyWeatherInfo): Boolean {
        return oldItem.apparentTemperature == newItem.apparentTemperature
    }

    override fun areContentsTheSame(oldItem: HourlyWeatherInfo, newItem: HourlyWeatherInfo): Boolean {
        return oldItem == newItem
    }
}