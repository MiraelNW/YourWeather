package com.example.yourweather.data.mapper

import com.example.yourweather.data.local.DailyWeatherDbModel
import com.example.yourweather.data.local.HourlyWeatherDbModel
import com.example.yourweather.data.remote.model.DailyWeatherDto
import com.example.yourweather.data.remote.model.HourlyWeatherDto

class Mapper {

    fun mapHourlyWeatherDtoToHourlyWeatherDbModel(
        hourlyDto: HourlyWeatherDto
    ) = HourlyWeatherDbModel(
        time= hourlyDto.time,
        apparentTemperature=hourlyDto.apparentTemperature,
        snowfall=hourlyDto.snowfall,
        visibility=hourlyDto.visibility,
        windSpeed10m=hourlyDto.windSpeed10m,
        windDirection10m=hourlyDto.windDirection10m,
        shortwaveRadiation=hourlyDto.shortwaveRadiation
    )

    fun mapDailyWeatherDtoToDailyWeatherDbModel(
        dailyWeatherDto: DailyWeatherDto
    ) = DailyWeatherDbModel(
        time= dailyWeatherDto.time,
        sunrise=dailyWeatherDto.sunrise,
        sunset=dailyWeatherDto.sunset,
        apparentTemperatureMax=dailyWeatherDto.apparentTemperatureMax,
        apparentTemperatureMin=dailyWeatherDto.apparentTemperatureMin
    )

    fun mapDailyWeatherDbModelToDailyDto(
        dailyWeatherDbModel: DailyWeatherDbModel
    ) = DailyWeatherDto(
        time =dailyWeatherDbModel.time,
        sunrise=dailyWeatherDbModel.sunrise,
        sunset=dailyWeatherDbModel.sunset,
        apparentTemperatureMax=dailyWeatherDbModel.apparentTemperatureMax,
        apparentTemperatureMin=dailyWeatherDbModel.apparentTemperatureMin,

    )

    fun mapHourlyWeatherDbModelToHourlyDto(
        hourlyWeatherDbModel: HourlyWeatherDbModel
    ) = HourlyWeatherDto(
        apparentTemperature=hourlyWeatherDbModel.apparentTemperature,
        snowfall=hourlyWeatherDbModel.snowfall,
        visibility=hourlyWeatherDbModel.visibility,
        windSpeed10m=hourlyWeatherDbModel.windSpeed10m,
        windDirection10m=hourlyWeatherDbModel.windDirection10m,
        shortwaveRadiation=hourlyWeatherDbModel.shortwaveRadiation
    )
}