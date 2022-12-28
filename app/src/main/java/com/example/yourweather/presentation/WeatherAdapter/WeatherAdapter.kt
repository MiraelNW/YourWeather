package com.example.yourweather.presentation.WeatherAdapter

import android.icu.number.NumberFormatter.with
import android.util.Log
import android.view.KeyCharacterMap.load
import android.view.LayoutInflater
import android.view.PointerIcon.load
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.yourweather.R
import com.example.yourweather.databinding.DailyWeatherItemBinding
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.squareup.picasso.Picasso
import java.lang.System.load
import java.text.SimpleDateFormat
import java.util.*

class WeatherAdapter : ListAdapter<DailyWeatherInfo, WeatherViewHolder>(WeatherInfoDiffCallback()) {

    var onWeekdayClickListener : OnWeekdayClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = DailyWeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherInfo = getItem(position)
        with(holder.binding) {


            apparentTemperatureTv.text =String.format("%s°",weatherInfo.temperature_2m_max?.toInt().toString())
            theHighestTemperature.text =String.format("%s°",weatherInfo.apparentTemperatureMax?.toInt().toString())
            theLowestTemperature.text =String.format("%s°",weatherInfo.apparentTemperatureMin?.toInt().toString())
            nameOfTheDayTv.text = weatherInfo.dailyTime

            when (weatherInfo.weatherCode) {
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
                    Log.d("Err", weatherInfo.weatherCode.toString())
                }

            }
        }

        holder.binding.root.setOnClickListener {
            onWeekdayClickListener?.onWeekdayClick(weatherInfo.dailyTime)
        }

    }



    interface OnWeekdayClickListener{
        fun onWeekdayClick(date : String)
    }
}