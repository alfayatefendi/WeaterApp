package com.example.weaterapp.domain.repository.location

import com.example.weaterapp.data.local.entity.RecentLocationEntity
import com.example.weaterapp.domain.model.location.LocationData
import com.example.weaterapp.domain.model.location.RecentLocation
import kotlinx.coroutines.flow.Flow

interface ILocationRepository {

    fun getLocation(name: String): Flow<Result<List<LocationData>>>

    fun getAllRecentLocation(): Flow<Result<List<RecentLocation>>>

    suspend fun insertRecentLocation(recentLocation: RecentLocationEntity)

    suspend fun deleteRecentLocation()
}