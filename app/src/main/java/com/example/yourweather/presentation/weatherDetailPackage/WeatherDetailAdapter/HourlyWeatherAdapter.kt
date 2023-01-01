package com.example.yourweather.presentation.weatherDetailPackage.WeatherDetailAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.yourweather.R
import com.example.yourweather.databinding.HourlyWeatherItemBinding
import com.example.yourweather.domain.entity.HourlyWeatherInfo
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class HourlyWeatherAdapter
    : ListAdapter<HourlyWeatherInfo, HourlyWeatherViewHolder>(HourlyWeatherDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherViewHolder {
        val binding = HourlyWeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HourlyWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HourlyWeatherViewHolder, position: Int) {
        val hourlyWeather = getItem(position)
        with(holder.binding) {
            nameOfTheDayTv.text = hourlyWeather.hourlyTime.substring(11)
            apparentTemperatureTv.text =
                String.format("%s°", hourlyWeather.apparentTemperature.roundToInt().toString())
            when (hourlyWeather.hourlyweathercode) {
                0 -> Picasso.get().load(R.drawable.ic_clear_day).into(weatherImage)
                1, 2 -> Picasso.get().load(R.drawable.ic_few_clouds).into(weatherImage)
                3, 45, 48 -> Picasso.get().load(R.drawable.ic_mostly_cloudy).into(weatherImage)
                51, 53, 55, 56, 57, 61, 63, 65, 66, 67, 80, 81, 82 -> Picasso.get()
                    .load(R.drawable.ic_shower_rain)
                    .into(weatherImage)
                71, 73, 75, 77, 85, 86 -> Picasso.get().load(R.drawable.ic_snow_weather)
                    .into(weatherImage)
                else -> {
                    Picasso.get().load(R.drawable.ic_unknown).into(weatherImage)
                }
            }
        }
    }
}