package com.example.yourweather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.yourweather.data.local.models.DailyWeatherDbModel
import com.example.yourweather.data.local.models.HourlyWeatherDbModel

@Dao
interface WeatherInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHourlyWeatherInfo(hourlyWeatherDbModel: HourlyWeatherDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyWeatherInfo( dailyWeatherDbModel: DailyWeatherDbModel)
}