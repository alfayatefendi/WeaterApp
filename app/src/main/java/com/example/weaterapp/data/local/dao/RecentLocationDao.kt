package com.example.weaterapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weaterapp.data.local.entity.RecentLocationEntity

@Dao
interface RecentLocationDao {

    @Query("SELECT * FROM recent_location ORDER by time DESC")
    fun getAllRecentLocation(): kotlinx.coroutines.flow.Flow<List<RecentLocationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentLocation(recentLocationDao: RecentLocationEntity)

    @Query("DELETE FROM recent_location")
    suspend fun deleteRecentLocation()
}