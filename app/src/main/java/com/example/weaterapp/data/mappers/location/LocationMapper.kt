package com.example.weaterapp.data.mappers.location

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weaterapp.data.local.entity.RecentLocationEntity
import com.example.weaterapp.data.remote.dto.location.LocationDto
import com.example.weaterapp.domain.model.location.LocationData
import com.example.weaterapp.domain.model.location.RecentLocation
import java.time.LocalDateTime
import java.time.ZoneOffset

fun LocationDto.toLocationData(): List<LocationData> {

    return this.results?.map {

        LocationData(
            longitude = it.longitude,
            latitude = it.latitude,
            name = it.name,
            admin = it.admin1?:"",
            country = it.country,
            countryCode = it.countryCode
        )
    }?: emptyList()
}

fun RecentLocationEntity.toRecentLocation(): RecentLocation {
    return RecentLocation(name)
}

@RequiresApi(Build.VERSION_CODES.O)
fun RecentLocation.toRecentLocationEntity(): RecentLocationEntity {
    return RecentLocationEntity(
        name = name,
        time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
    )
}