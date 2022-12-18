package com.example.yourweather.data.mapper

import com.example.yourweather.data.local.models.DailyWeatherDbModel
import com.example.yourweather.data.local.models.HourlyWeatherDbModel
import com.example.yourweather.data.remote.model.DailyWeatherDto
import com.example.yourweather.data.remote.model.HourlyWeatherDto

class Mapper {

    fun mapHourlyWeatherDtoToHourlyWeatherDbModel(
        hourlyDto: HourlyWeatherDto,
        hour: Int
    ) = HourlyWeatherDbModel(
        hourlyTime = hourlyDto.time[hour],
        apparentTemperature=hourlyDto.apparentTemperature[hour],
        snowfall=hourlyDto.snowfall[hour],
        visibility=hourlyDto.visibility[hour],
        windSpeed10m=hourlyDto.windSpeed10m[hour],
        windDirection10m=hourlyDto.windDirection10m[hour],
        shortwaveRadiation=hourlyDto.shortwaveRadiation[hour],
        relativehumidity_2m=hourlyDto.relativehumidity_2m[hour]
    )

    fun mapDailyWeatherDtoToDailyWeatherDbModel(
        dailyWeatherDto: DailyWeatherDto,
        index: Int
    ) = DailyWeatherDbModel(
        dailyTime= dailyWeatherDto.time[index],
        sunrise=dailyWeatherDto.sunrise[index],
        sunset=dailyWeatherDto.sunset[index],
        apparentTemperatureMax=dailyWeatherDto.apparentTemperatureMax[index],
        apparentTemperatureMin=dailyWeatherDto.apparentTemperatureMin[index]
    )


}