package com.example.yourweather.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yourweather.data.local.models.DailyWeatherDbModel
import com.example.yourweather.data.local.models.HourlyWeatherDbModel

@Database(entities = [HourlyWeatherDbModel::class, DailyWeatherDbModel::class], version = 3, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        private const val DB_NAME = "AppDatabase"
        private val lock = Any()
        private var db: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            kotlin.synchronized(lock) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }

    }

    abstract fun weatherInfoDao() : WeatherInfoDao
}