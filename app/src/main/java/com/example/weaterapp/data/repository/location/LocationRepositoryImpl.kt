package com.example.weaterapp.data.repository.location

import com.example.weaterapp.data.local.dao.RecentLocationDao
import com.example.weaterapp.data.local.entity.RecentLocationEntity
import com.example.weaterapp.data.mappers.location.toLocationData
import com.example.weaterapp.data.mappers.location.toRecentLocation
import com.example.weaterapp.data.remote.service.LocationApi
import com.example.weaterapp.domain.model.location.LocationData
import com.example.weaterapp.domain.model.location.RecentLocation
import com.example.weaterapp.domain.repository.location.ILocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(

    private val locationApi: LocationApi,
    private val recentLocationDao: RecentLocationDao
): ILocationRepository {

    override fun getLocation(name: String): Flow<Result<List<LocationData>>> = flow{
        try {
            val response = locationApi.getLocation(name).toLocationData()
            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override fun getAllRecentLocation(): Flow<Result<List<RecentLocation>>> =
        recentLocationDao.getAllRecentLocation().map{
            val recentLocation = it.map { it.toRecentLocation() }
            Result.success(recentLocation)
    }.catch { e ->
            emit(Result.failure(e))
        }

    override suspend fun insertRecentLocation(recentLocation: RecentLocationEntity) {
        recentLocationDao.insertRecentLocation(recentLocation)
    }

    override suspend fun deleteRecentLocation() {
        recentLocationDao.deleteRecentLocation()
    }

}