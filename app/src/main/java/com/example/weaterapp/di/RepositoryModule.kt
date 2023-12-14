package com.example.weaterapp.di

import com.example.weaterapp.data.repository.location.LocationRepositoryImpl
import com.example.weaterapp.data.repository.weather.WeatherRepositoryImpl
import com.example.weaterapp.domain.repository.location.ILocationRepository
import com.example.weaterapp.domain.repository.weather.IWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIWeatherRepository (
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): IWeatherRepository

    @Binds
    @Singleton
    abstract fun bindILocationRepository (
        locationRepositoryImpl: LocationRepositoryImpl
    ): ILocationRepository
}