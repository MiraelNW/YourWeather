package com.example.yourweather.presentation.WeatherAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.yourweather.databinding.DailyWeatherItemBinding
import com.example.yourweather.domain.entity.DailyWeatherInfo

class WeatherAdapter : ListAdapter<DailyWeatherInfo, WeatherViewHolder>(WeatherInfoDiffCallback()) {



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
        with(holder.binding){
            precipitationSumTv.text = weatherInfo.precipitation_sum.toString()
            theHighestTemperature.text = weatherInfo.apparentTemperatureMax.toString()
            theLowestTemperature.text = weatherInfo.apparentTemperatureMin.toString()
        }


    }
}