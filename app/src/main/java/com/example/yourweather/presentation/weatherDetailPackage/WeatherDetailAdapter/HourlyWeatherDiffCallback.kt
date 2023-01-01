package com.example.yourweather.presentation.weatherDetailPackage.WeatherDetailAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.yourweather.domain.entity.HourlyWeatherInfo

class HourlyWeatherDiffCallback : DiffUtil.ItemCallback<HourlyWeatherInfo>() {
    override fun areItemsTheSame(oldItem: HourlyWeatherInfo, newItem: HourlyWeatherInfo): Boolean {
        return oldItem.apparentTemperature == newItem.apparentTemperature
    }

    override fun areContentsTheSame(
        oldItem: HourlyWeatherInfo,
        newItem: HourlyWeatherInfo
    ): Boolean {
        return oldItem == newItem
    }
}