package com.example.weaterapp.domain.repository.weather

import com.example.weaterapp.domain.model.weather.WeatherInfo

interface IWeatherRepository {

    suspend fun getWeatherData(day: Int, lat: Double, long: Double): Result<WeatherInfo>
}