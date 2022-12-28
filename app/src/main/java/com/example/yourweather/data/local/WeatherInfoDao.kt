package com.example.yourweather.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yourweather.data.local.models.DailyWeatherDbModel
import com.example.yourweather.data.local.models.HourlyWeatherDbModel

@Dao
interface WeatherInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHourlyWeatherInfo(hourlyWeatherDbModel: HourlyWeatherDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyWeatherInfo(dailyWeatherDbModel: DailyWeatherDbModel)

    @Query("SELECT * FROM HourlyWeatherTable WHERE hourlyTime =:hourlyTime")
    fun getHourlyWeatherByTime(hourlyTime: String): LiveData<HourlyWeatherDbModel>

    @Query("SELECT * FROM DailyWeatherTable")
    fun getListDailyWeatherByTime(): LiveData<List<DailyWeatherDbModel>>

    @Query("SELECT * FROM DailyWeatherTable WHERE dailyTime =:dailyTime")
    fun getDailyWeatherByTime(dailyTime: String): LiveData<DailyWeatherDbModel>
}