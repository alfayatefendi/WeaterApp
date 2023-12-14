package com.example.weaterapp.data.repository.weather

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weaterapp.data.mappers.weather.toWheaterInfo
import com.example.weaterapp.data.remote.service.WeatherApi
import com.example.weaterapp.domain.model.weather.WeatherInfo
import com.example.weaterapp.domain.repository.weather.IWeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(

    private val weatherApi: WeatherApi
): IWeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(day: Int, lat: Double, long: Double): Result<WeatherInfo> {
        return try {
            Result.success(weatherApi.getWeatherData(lat, long).toWheaterInfo(day))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}