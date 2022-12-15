package com.example.yourweather.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yourweather.data.remote.model.DailyWeatherDto
import com.example.yourweather.data.remote.model.HourlyWeatherDto
import kotlinx.coroutines.internal.synchronized

@Database(entities = [HourlyWeatherDbModel::class,DailyWeatherDbModel::class], version = 1, exportSchema = false)
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