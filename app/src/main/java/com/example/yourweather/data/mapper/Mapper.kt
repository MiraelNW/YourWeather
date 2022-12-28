package com.example.yourweather.data.mapper

import com.example.yourweather.data.local.models.DailyWeatherDbModel
import com.example.yourweather.data.local.models.HourlyWeatherDbModel
import com.example.yourweather.data.remote.model.DailyWeatherDto
import com.example.yourweather.data.remote.model.HourlyWeatherDto
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.example.yourweather.domain.entity.HourlyWeatherInfo
import java.text.SimpleDateFormat
import java.util.*

class Mapper {

    fun mapHourlyWeatherDtoToHourlyWeatherDbModel(
        hourlyDto: HourlyWeatherDto,
        hour: Int
    ) = HourlyWeatherDbModel(
        hourlyTime = hourlyDto.time[hour],
        apparentTemperature = hourlyDto.apparentTemperature[hour],
        snowfall = hourlyDto.snowfall[hour],
        visibility = hourlyDto.visibility[hour],
        windSpeed10m = hourlyDto.windSpeed10m[hour],
        windDirection10m = hourlyDto.windDirection10m[hour],
        shortwaveRadiation = hourlyDto.shortwaveRadiation[hour],
        relativehumidity_2m = hourlyDto.relativehumidity_2m[hour],
        temperature_2m = hourlyDto.temperature_2m[hour]

    )

    fun mapDailyWeatherDtoToDailyWeatherDbModel(
        dailyWeatherDto: DailyWeatherDto,
        day: Int
    ) = DailyWeatherDbModel(
        dailyTime = dailyWeatherDto.time[day],
        sunrise = dailyWeatherDto.sunrise[day],
        sunset = dailyWeatherDto.sunset[day],
        apparentTemperatureMax = dailyWeatherDto.apparentTemperatureMax[day],
        apparentTemperatureMin = dailyWeatherDto.apparentTemperatureMin[day],
        precipitation_sum = dailyWeatherDto.precipitation_sum[day],
        weatherCode = dailyWeatherDto.weatherCode[day],
        temperature_2m_max = dailyWeatherDto.temperature_2m_max[day]
    )

    fun mapHourlyWeatherDbToHourlyWeatherInfo(
        hourlyWeatherDbModel: HourlyWeatherDbModel,
    ) = HourlyWeatherInfo(
        hourlyTime = hourlyWeatherDbModel.hourlyTime,
        apparentTemperature = hourlyWeatherDbModel.apparentTemperature,
        snowfall = hourlyWeatherDbModel.snowfall,
        visibility = hourlyWeatherDbModel.visibility,
        windSpeed10m = hourlyWeatherDbModel.windSpeed10m,
        windDirection10m = hourlyWeatherDbModel.windDirection10m,
        shortwaveRadiation = hourlyWeatherDbModel.shortwaveRadiation,
        relativehumidity_2m = hourlyWeatherDbModel.relativehumidity_2m,
        temperature_2m = hourlyWeatherDbModel.temperature_2m
    )

    fun mapDailyWeatherDbToDailyWeatherInfo(
        dailyWeatherDbModel: DailyWeatherDbModel,
    ) = DailyWeatherInfo(
        dailyTime = mapDailyTime(dailyWeatherDbModel.dailyTime),
        sunrise =dailyWeatherDbModel.sunrise,
        sunset = dailyWeatherDbModel.sunset,
        apparentTemperatureMax = dailyWeatherDbModel.apparentTemperatureMax,
        apparentTemperatureMin = dailyWeatherDbModel.apparentTemperatureMin,
        precipitation_sum = dailyWeatherDbModel.precipitation_sum,
        weatherCode = dailyWeatherDbModel.weatherCode,
        temperature_2m_max = dailyWeatherDbModel.temperature_2m_max
    )

    private fun mapDailyTime(dailyTime: String): String {
        val date = SimpleDateFormat("yyyy-MM-dd").parse(dailyTime)
        val calendar = Calendar.getInstance()
        date?.let {
            calendar.time = it
        }
        val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]
        return when (dayOfWeek) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> ""

        }
    }


}