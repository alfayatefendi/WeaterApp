package com.example.weaterapp.di

import com.example.weaterapp.data.location.DefaultLocationTracker
import com.example.weaterapp.domain.location.ILocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@OptIn(ExperimentalCoroutinesApi::class)
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindILocationTracker (
        defaultLocationTracker: DefaultLocationTracker
    ): ILocationTracker
}