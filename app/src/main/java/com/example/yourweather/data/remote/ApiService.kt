package com.example.yourweather.data.remote

import android.util.Log
import com.example.yourweather.data.remote.model.CityCoordDto
import com.example.yourweather.data.remote.model.ListOfCitiesDto
import com.example.yourweather.data.remote.model.WeatherByCoord
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/forecast")
     suspend fun getForecastByGeoCords(
        @Query("latitude") latitude:Double,
        @Query("longitude") longitude:Double,
        @Query("hourly")   apparent_temperature :String = "apparent_temperature",
        @Query("hourly")   snowfall :String = "snowfall",
        @Query("hourly")   visibility :String = "visibility",
        @Query("hourly")   windspeed_10m :String = "windspeed_10m",
        @Query("hourly")   winddirection_10m :String = "winddirection_10m",
        @Query("hourly")   shortwave_radiation :String = "shortwave_radiation",
        @Query("daily")    sunrise :String = "sunrise",
        @Query("daily")    sunset :String = "sunset",
        @Query("daily")    apparent_temperature_max :String = "apparent_temperature_max",
        @Query("daily")    apparent_temperature_min :String = "apparent_temperature_min",
        @Query("timezone") timezone :String = "auto",
    ):WeatherByCoord

     @GET("search")
     suspend fun getCoordByCityName(
         @Query("name")city :String,
         @Query ("count") count :Int =1
     ):ListOfCitiesDto
}