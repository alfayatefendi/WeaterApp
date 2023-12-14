package com.example.weaterapp.data.remote.service

import com.example.weaterapp.data.remote.dto.weather.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,apparent_temperature&timezone=Asia/Bangkok")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double
    ): WeatherDto
}