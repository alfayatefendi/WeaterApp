package com.example.weaterapp.domain.model.weather

import java.time.LocalDateTime

data class WeatherData (

    val latitude: Double,
    val longitude: Double,
    val temperatureCelcius: Double,
    val feelsLikeCelcius: Double,
    val windSpeed: Double,
    val humidity: Double,
    val time: LocalDateTime,
    val weatherType: WeatherType

)