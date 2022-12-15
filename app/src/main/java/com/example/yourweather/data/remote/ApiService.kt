package com.example.yourweather.data.remote

import com.example.yourweather.data.remote.model.WeatherByCoord
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast")
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
}