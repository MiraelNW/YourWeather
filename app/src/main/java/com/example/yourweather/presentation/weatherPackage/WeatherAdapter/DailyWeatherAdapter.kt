package com.example.yourweather.presentation.weatherPackage.WeatherAdapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.example.yourweather.R
import com.example.yourweather.databinding.DailyWeatherItemBinding
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class DailyWeatherAdapter :
    ListAdapter<DailyWeatherInfo, DailyWeatherViewHolder>(DailyWeatherInfoDiffCallback) {

    var onWeekdayClickListener: OnWeekdayClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyWeatherViewHolder {
        val binding = DailyWeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DailyWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyWeatherViewHolder, position: Int) {
        val weatherInfo = getItem(position)
        with(holder.binding) {
            when (position) {
                0 -> {
                    val color = ContextCompat.getColor(holder.itemView.context, R.color.gold)
                    mainCard.setCardBackgroundColor(ColorStateList.valueOf(color))
                }
                1 -> {
                    val color = ContextCompat.getColor(holder.itemView.context, R.color.Magenta)
                    mainCard.setCardBackgroundColor(ColorStateList.valueOf(color))
                }
                2 -> {
                    val color = ContextCompat.getColor(holder.itemView.context, R.color.darkCyan)
                    mainCard.setCardBackgroundColor(ColorStateList.valueOf(color))
                }
                3 -> {
                    val color = ContextCompat.getColor(holder.itemView.context, R.color.indigo)
                    mainCard.setCardBackgroundColor(ColorStateList.valueOf(color))
                }
                4 -> {
                    val color = ContextCompat.getColor(holder.itemView.context, R.color.lime)
                    mainCard.setCardBackgroundColor(ColorStateList.valueOf(color))
                }
                5 -> {
                    val color = ContextCompat.getColor(holder.itemView.context, R.color.royalBlue)
                    mainCard.setCardBackgroundColor(ColorStateList.valueOf(color))
                }
            }

            apparentTemperatureTv.text =
                String.format(
                    holder.itemView.context.getString(R.string.temp),
                    weatherInfo.apparentTemperatureMax?.roundToInt().toString()
                )
            theHighestTemperature.text =
                String.format(
                    holder.itemView.context.getString(R.string.temp),
                    weatherInfo.temperature_2m_max?.roundToInt().toString()
                )
            theLowestTemperature.text =
                String.format(
                    holder.itemView.context.getString(R.string.temp),
                    weatherInfo.apparentTemperatureMin?.roundToInt().toString()
                )
            nameOfTheDayTv.text = weatherInfo.dayOfWeek

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
                }
            }
            with(weatherInfo) {
                root.setOnClickListener {
                    onWeekdayClickListener?.onWeekdayClick(this)
                }
            }

        }

    }

    interface OnWeekdayClickListener {
        fun onWeekdayClick(dailyWeatherInfo: DailyWeatherInfo)
    }
}