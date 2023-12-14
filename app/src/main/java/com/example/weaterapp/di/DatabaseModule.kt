package com.example.weaterapp.di

import android.content.Context
import androidx.room.Room
import com.example.weaterapp.data.local.dao.RecentLocationDao
import com.example.weaterapp.data.local.database.WeatherDatabase
import com.example.weaterapp.utils.Constant.WEATHER_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideWeatherDatabase(
        @ApplicationContext context: Context
    ): WeatherDatabase =
        Room.databaseBuilder(
            context, WeatherDatabase::class.java,
            WEATHER_DB
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRecentLocationDao(weatherDatabase: WeatherDatabase): RecentLocationDao =
        weatherDatabase.recentLocationDao()
}