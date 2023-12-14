package com.example.weaterapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weaterapp.data.local.dao.RecentLocationDao
import com.example.weaterapp.data.local.entity.RecentLocationEntity


@Database(entities = [RecentLocationEntity::class], version = 1, exportSchema = false)

abstract class WeatherDatabase: RoomDatabase() {

    abstract fun recentLocationDao(): RecentLocationDao
}