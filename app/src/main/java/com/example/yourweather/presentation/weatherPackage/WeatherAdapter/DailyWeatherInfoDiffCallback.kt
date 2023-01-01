package com.example.yourweather.presentation.weatherPackage.WeatherAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.yourweather.domain.entity.DailyWeatherInfo

object DailyWeatherInfoDiffCallback : DiffUtil.ItemCallback<DailyWeatherInfo>(){
    override fun areItemsTheSame(oldItem: DailyWeatherInfo, newItem: DailyWeatherInfo): Boolean {
        return oldItem.apparentTemperatureMax == newItem.apparentTemperatureMax
    }

    override fun areContentsTheSame(oldItem: DailyWeatherInfo, newItem: DailyWeatherInfo): Boolean {
        return oldItem == newItem
    }
}