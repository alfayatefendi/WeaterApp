package com.example.weaterapp.ui.home

import com.example.weaterapp.domain.model.weather.WeatherInfo

data class WeatherUiState (

    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val weatherInfo: WeatherInfo? = null

)