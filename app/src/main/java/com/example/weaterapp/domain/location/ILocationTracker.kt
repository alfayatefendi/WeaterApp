package com.example.weaterapp.domain.location

import android.location.Location

interface ILocationTracker {

    suspend fun getCurrentLocation(): Location?
}