package com.example.weaterapp.data.remote.dto.location

import com.google.gson.annotations.SerializedName

data class LocationDto (

    @SerializedName("generationtime_ms")
    val generationtimeMs: Any,

    @SerializedName("results")
    val results: List<LocationDataDto>? = null
)