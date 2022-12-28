package com.example.yourweather.data.remote

import com.example.yourweather.data.remote.model.coords.ListOfCitiesDto
import com.example.yourweather.data.remote.model.WeatherByCoord
import com.example.yourweather.data.remote.model.coords.CityCoordDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/forecast")
    suspend fun getForecastByGeoCords(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") apparent_temperature: String = "apparent_temperature",
        @Query("hourly") snowfall: String = "snowfall",
        @Query("hourly") visibility: String = "visibility",
        @Query("hourly") windspeed_10m: String = "windspeed_10m",
        @Query("hourly") winddirection_10m: String = "winddirection_10m",
        @Query("hourly") shortwave_radiation: String = "shortwave_radiation",
        @Query("hourly") relativehumidity_2m: String = "relativehumidity_2m",
        @Query("hourly") temperature_2m: String = "temperature_2m",
        @Query("daily") sunrise: String = "sunrise",
        @Query("daily") sunset: String = "sunset",
        @Query("daily") apparent_temperature_max: String = "apparent_temperature_max",
        @Query("daily") apparent_temperature_min: String = "apparent_temperature_min",
        @Query("daily") precipitation_sum: String = "precipitation_sum",
        @Query("daily") weathercode: String = "weathercode",
        @Query("daily") temperature_2m_max: String = "temperature_2m_max",
        @Query("timezone") timezone: String = "auto",

    ): WeatherByCoord

    @GET("search")
    suspend fun getCoordByCityName(
        @Query("name") city: String,
        @Query("count") count: Int = 1
    ): ListOfCitiesDto
}